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

package georegression.metric;

import georegression.struct.point.Point2D_F64;
import georegression.struct.shapes.Polygon2D_F64;
import georegression.struct.shapes.Quadrilateral_F64;

/**
 * The area contained inside 2D shapes
 *
 * @author Peter Abeles
 */
public class Area2D_F64 {

	/**
	 * Computes the area of an arbitrary triangle from 3-vertices.
	 *
	 * area = | a.x*(b.y - c.y) + b.x*(c.y - a.y) + c.x*(a.y - b.y) | / 2
	 *
	 * @param a Corner point 1
	 * @param b Corner point 2
	 * @param c Corner point 3
	 * @return area
	 */
	public static double triangle( Point2D_F64 a, Point2D_F64 b, Point2D_F64  c ) {
		double inner = a.x*(b.y - c.y) + b.x*(c.y - a.y) + c.x*(a.y - b.y);

		return Math.abs(inner/2.0);
	}

	/**
	 * Area of a quadrilateral computed from two triangles.
	 *
	 * @param quad quadrilateral
	 * @return area
	 */
	public static double quadrilateral( Quadrilateral_F64 quad ) {
		return triangle(quad.a,quad.b,quad.d) + triangle(quad.b,quad.c,quad.d);
	}

	/**
	 * Area of a convex polygon
	 * @param poly Convex polygon
	 * @return area
	 */
	public static double polygonConvex( Polygon2D_F64 poly ) {
		double total = 0;

		for (int i = 2; i < poly.size(); i++) {
			Point2D_F64 v0 = poly.get(i-2);
			Point2D_F64 v1 = poly.get(i-1);
			Point2D_F64 v2 = poly.get(i);

			total += triangle(v0,v1,v2);
		}

		return total;
	}
}
