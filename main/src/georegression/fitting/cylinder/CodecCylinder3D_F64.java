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

import georegression.struct.shapes.Cylinder3D_F64;
import org.ddogleg.fitting.modelset.ModelCodec;

/**
 * Encodes and decodes {@link Cylinder3D_F64} into double[].
 * <pre>
 * cylinder.line.p.x = input[0];
 * cylinder.line.p.y = input[1];
 * cylinder.line.p.z = input[2];
 * cylinder.line.slope.x = input[3];
 * cylinder.line.slope.y = input[4];
 * cylinder.line.slope.z = input[5];
 * cylinder.radius = input[6];
 * </pre>
 *
 * @author Peter Abeles
 */
public class CodecCylinder3D_F64 implements ModelCodec<Cylinder3D_F64> {
	@Override
	public void decode( /**/double[] input, Cylinder3D_F64 cylinder) {
		cylinder.line.p.x = (double) input[0];
		cylinder.line.p.y = (double) input[1];
		cylinder.line.p.z = (double) input[2];
		cylinder.line.slope.x = (double) input[3];
		cylinder.line.slope.y = (double) input[4];
		cylinder.line.slope.z = (double) input[5];
		cylinder.radius = (double) input[6];
	}

	@Override
	public void encode(Cylinder3D_F64 cylinder, /**/double[] param) {
		param[0] = cylinder.line.p.x;
		param[1] = cylinder.line.p.y;
		param[2] = cylinder.line.p.z;
		param[3] = cylinder.line.slope.x;
		param[4] = cylinder.line.slope.y;
		param[5] = cylinder.line.slope.z;
		param[6] = cylinder.radius;
	}

	@Override
	public int getParamLength() {
		return 7;
	}
}
