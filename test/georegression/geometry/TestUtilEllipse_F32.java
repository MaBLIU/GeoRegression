/*
 * Copyright (c) 2011-2013, Peter Abeles. All Rights Reserved.
 *
 * This file is part of Geometric Regression Library (GeoRegression).
 *
 * GeoRegression is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *
 * GeoRegression is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with GeoRegression.  If not, see <http://www.gnu.org/licenses/>.
 */

package georegression.geometry;

import georegression.misc.GrlConstants;
import georegression.struct.point.Point2D_F32;
import georegression.struct.shapes.EllipseQuadratic_F32;
import georegression.struct.shapes.EllipseRotated_F32;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author Peter Abeles
 */
public class TestUtilEllipse_F32 {

	Random rand = new Random(234);

	@Test
	public void convert_back_forth() {
		convert_back_forth(0,0,4.5f,3,0);
		convert_back_forth(1,2,4.5f,3,0);
		convert_back_forth(0,0,4.5f,3,(float)Math.PI/4);
		convert_back_forth(0,0,4.5f,3,0.1f);
		convert_back_forth(-2,1.5f,4.5f,3,-0.1f);

		convert_back_forth(1,2,3,1.5f,0);

		// see if it can handle a circle
		convert_back_forth(0,0,3,3,0);
	}

	@Test
	public void convert_back_forth_random() {

		for( int i = 0; i < 100; i++ ) {
			float x = (rand.nextFloat()-0.5f)*2;
			float y = (rand.nextFloat()-0.5f)*2;
			float theta = (rand.nextFloat()-0.5f)*(float)Math.PI;
			float b = rand.nextFloat()*2+0.1f;
			float a = b+rand.nextFloat();

			convert_back_forth(x,y,a,b,theta);
		}
	}

	public void convert_back_forth( float x0 , float y0, float a, float b, float phi ) {
		EllipseRotated_F32 rotated = new EllipseRotated_F32(x0,y0,a,b,phi);
		EllipseQuadratic_F32 quad = new EllipseQuadratic_F32();
		EllipseRotated_F32 found = new EllipseRotated_F32();

		UtilEllipse_F32.convert(rotated,quad);
		UtilEllipse_F32.convert(quad,found);

		assertEquals(rotated.center.x,found.center.x, GrlConstants.FLOAT_TEST_TOL);
		assertEquals(rotated.center.y,found.center.y, GrlConstants.FLOAT_TEST_TOL);
		assertEquals(rotated.a,found.a, GrlConstants.FLOAT_TEST_TOL);
		assertEquals(rotated.b,found.b, GrlConstants.FLOAT_TEST_TOL);
		assertEquals(rotated.phi,found.phi, GrlConstants.FLOAT_TEST_TOL);
	}

	@Test
	public void convert_rotated_to_quad() {
		EllipseRotated_F32 rotated = new EllipseRotated_F32(1,2,4.5f,3,0.2f);

		Point2D_F32 p = UtilEllipse_F32.computePoint(0.45f,rotated,null);

		float eval = UtilEllipse_F32.evaluate(p.x,p.y,rotated);
		assertEquals(1,eval, GrlConstants.FLOAT_TEST_TOL);

		EllipseQuadratic_F32 quad = new EllipseQuadratic_F32();
		UtilEllipse_F32.convert(rotated,quad);
		eval = UtilEllipse_F32.evaluate(p.x,p.y,quad);
		assertEquals(0,eval, GrlConstants.FLOAT_TEST_TOL);
	}

	/**
	 * Tests computePoint and evaluate(rotated) by computes points around the ellipse and seeing if they
	 * meet the expected results.
	 */
	@Test
	public void computePoint_evaluate_rotated() {
		EllipseRotated_F32 rotated = new EllipseRotated_F32(1,2,4.5f,3,0.2f);

		for( int i = 0; i < 100; i++ ) {
			float t = (float)Math.PI*2*i/100.0f;
			Point2D_F32 p = UtilEllipse_F32.computePoint(t,rotated,null);
			float eval = UtilEllipse_F32.evaluate(p.x,p.y,rotated);
			assertEquals(1,eval, GrlConstants.FLOAT_TEST_TOL);
		}
	}

	@Test
	public void computePoint_evaluate_quadratic() {
		EllipseRotated_F32 rotated = new EllipseRotated_F32(1,2,4.5f,3,0.2f);
		EllipseQuadratic_F32 quad = new EllipseQuadratic_F32();
		UtilEllipse_F32.convert(rotated,quad);

		for( int i = 0; i < 100; i++ ) {
			float t = (float)Math.PI*2*i/100.0f;
			Point2D_F32 p = UtilEllipse_F32.computePoint(t,rotated,null);
			float eval = UtilEllipse_F32.evaluate(p.x,p.y,quad);
			assertEquals(0,eval, GrlConstants.FLOAT_TEST_TOL);
		}
	}

}