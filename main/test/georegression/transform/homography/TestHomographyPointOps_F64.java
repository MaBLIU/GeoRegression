/*
 * Copyright (C) 2011-2015, Peter Abeles. All Rights Reserved.
 *
 * This file is part of Geometric Regression Library (GeoRegression).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package georegression.transform.homography;

import georegression.geometry.GeometryMath_F64;
import georegression.misc.GrlConstants;
import georegression.struct.homography.Homography2D_F64;
import georegression.struct.homography.UtilHomography;
import georegression.struct.point.Point2D_F64;
import org.ejml.data.DenseMatrix64F;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;


/**
 * @author Peter Abeles
 */
public class TestHomographyPointOps_F64 {

	DenseMatrix64F M = new DenseMatrix64F(3,3);
	Homography2D_F64 tran = new Homography2D_F64();

	public TestHomographyPointOps_F64() {
		Random rand = new Random(234);
		
		tran.a11 = rand.nextGaussian();
		tran.a12 = rand.nextGaussian();
		tran.a13 = rand.nextGaussian();
		tran.a21 = rand.nextGaussian();
		tran.a22 = rand.nextGaussian();
		tran.a23 = rand.nextGaussian();
		tran.a31 = rand.nextGaussian();
		tran.a32 = rand.nextGaussian();
		tran.a33 = rand.nextGaussian();

		UtilHomography.convert(tran,M);
	}

	@Test
	public void transform_Point_F64() {
		Point2D_F64 src = new Point2D_F64(1,2);
		Point2D_F64 dst = new Point2D_F64();
		Point2D_F64 expected = new Point2D_F64();

		HomographyPointOps_F64.transform(tran, src, dst);

		GeometryMath_F64.mult(M,src,expected);
		
		assertEquals(expected.x,dst.x, GrlConstants.DOUBLE_TEST_TOL);
		assertEquals(expected.y,dst.y, GrlConstants.DOUBLE_TEST_TOL);
	}

	@Test
	public void transform_DD_F64() {
		Point2D_F64 src = new Point2D_F64(1,2);
		Point2D_F64 dst = new Point2D_F64();
		Point2D_F64 expected = new Point2D_F64();

		HomographyPointOps_F64.transform(tran, 1, 2, dst);

		GeometryMath_F64.mult(M,src,expected);

		assertEquals(expected.x,dst.x, GrlConstants.DOUBLE_TEST_TOL);
		assertEquals(expected.y,dst.y, GrlConstants.DOUBLE_TEST_TOL);
	}
}
