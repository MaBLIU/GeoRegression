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

package georegression.fitting.cylinder;

import georegression.misc.GrlConstants;
import georegression.struct.shapes.Cylinder3D_F32;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Peter Abeles
 */
public class TestModelManagerCylinder3D_F32 {

	@Test
	public void createModelInstance() {
		ModelManagerCylinder3D_F32 alg = new ModelManagerCylinder3D_F32();

		assertTrue( alg.createModelInstance() != null);
	}

	@Test
	public void copyModel() {
		ModelManagerCylinder3D_F32 alg = new ModelManagerCylinder3D_F32();

		Cylinder3D_F32 model = new Cylinder3D_F32(1,2,3,4,5,6,7);
		Cylinder3D_F32 found = new Cylinder3D_F32();

		alg.copyModel(model,found);

		assertEquals(model.line.p.x, found.line.p.x, GrlConstants.FLOAT_TEST_TOL);
		assertEquals(model.line.p.y,found.line.p.y, GrlConstants.FLOAT_TEST_TOL);
		assertEquals(model.line.p.z,found.line.p.z, GrlConstants.FLOAT_TEST_TOL);

		assertEquals(model.line.slope.x,found.line.slope.x, GrlConstants.FLOAT_TEST_TOL);
		assertEquals(model.line.slope.y,found.line.slope.y, GrlConstants.FLOAT_TEST_TOL);
		assertEquals(model.line.slope.z,found.line.slope.z, GrlConstants.FLOAT_TEST_TOL);

		assertEquals(model.radius,found.radius, GrlConstants.FLOAT_TEST_TOL);
	}

}
