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

package georegression.fitting.sphere;

import georegression.struct.shapes.Sphere3D_F64;
import org.ddogleg.fitting.modelset.ModelManager;

/**
 * Manages {@link georegression.struct.shapes.Sphere3D_F64}.
 *
 * @author Peter Abeles
 */
public class ModelManagerSphere3D_F64 implements ModelManager<Sphere3D_F64> {
	@Override
	public Sphere3D_F64 createModelInstance() {
		return new Sphere3D_F64();
	}

	@Override
	public void copyModel(Sphere3D_F64 src, Sphere3D_F64 dst) {
		dst.set(src);
	}
}
