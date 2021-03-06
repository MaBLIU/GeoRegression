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

package georegression.struct.point;

import georegression.geometry.UtilVector2D_F32;
import georegression.struct.GeoTuple2D_F32;

/**
 * Spacial vector in 2D
 */
@SuppressWarnings({"unchecked"})
public class Vector2D_F32 extends GeoTuple2D_F32<Vector2D_F32> {

	public Vector2D_F32( GeoTuple2D_F32 orig ) {
		this(orig.x,orig.y);
	}

	public Vector2D_F32( float x, float y ) {
		set( x, y );
	}

	public Vector2D_F32() {
	}

	public Vector2D_F32( Vector2D_F32 pt ) {
		set( pt.x, pt.y );
	}

	@Override
	public Vector2D_F32 createNewInstance() {
		return new Vector2D_F32();
	}

	public void set( Vector2D_F32 orig ) {
		_set( orig );
	}

	public Vector2D_F32 copy() {
		return new Vector2D_F32( this );
	}

	public void normalize() {
		float r = norm();
		x /= r;
		y /= r;
	}

	public String toString() {
		return "V( " + x + " " + y + " )";
	}

	/**
	 * Dot product between this and 'a' = this.x * a.x + this.y * a.y
	 *
	 * @param a A vector
	 * @return dot product.
	 */
	public float dot( Vector2D_F32 a ) {
		return x * a.x + y * a.y;
	}

	/**
	 * Returns the acute angle between the two vectors.  Computed using the dot product.
	 * @param a Vector
	 * @return Acute angle in radians between 'this' and 'a'.
	 */
	public float acute( Vector2D_F32 a ) {
		return UtilVector2D_F32.acute(this, a);
	}
}