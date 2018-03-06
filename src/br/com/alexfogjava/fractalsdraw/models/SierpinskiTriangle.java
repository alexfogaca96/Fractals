package br.com.alexfogjava.fractalsdraw.models;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.LinkedList;
import java.util.Stack;

import br.com.alexfogjava.fractalsdraw.fractal.PaintableFractal;
import br.com.alexfogjava.fractalsdraw.fractal.Point;
import br.com.alexfogjava.fractalsdraw.models.shapes.Triangle;

public class SierpinskiTriangle extends PaintableFractal
{
	private static final long serialVersionUID = 7913555740382313000L;

	private final Stack<LinkedList<Triangle>> triangles = new Stack<LinkedList<Triangle>> ();

	public SierpinskiTriangle ( int frameXSize, int frameYSize )
	{
		this.setPreferredSize ( new Dimension ( frameXSize, frameYSize ) );
		frameXSize = frameYSize = frameXSize - 5;

		final int xTopPoint = frameXSize / 2;
		final int yTopPoint = 0;

		final int side = frameXSize;

		final int yBottomPoints = ( int ) ( side * 0.866 );

		final int xLeftPoint = 0;
		final int xRightPoint = frameXSize;

		final LinkedList<Triangle> listToBeAdded = new LinkedList<Triangle> ();
		listToBeAdded.add ( new Triangle ( new Point ( xTopPoint, yTopPoint ), new Point ( xLeftPoint, yBottomPoints ),
				new Point ( xRightPoint, yBottomPoints ) ) );

		this.triangles.push ( listToBeAdded );
	}

	@Override
	protected void paintComponent ( final Graphics g )
	{
		super.paintComponent ( g );

		g.setColor ( Color.BLACK );

		final LinkedList<Triangle> triangleList = this.triangles.peek ();
		for ( final Triangle triangle : triangleList )
		{
			g.fillPolygon (
					new Polygon ( triangle.getPointsX (), triangle.getPointsY (), Triangle.getNumberOfSides () ) );
		}
	}

	@Override
	public void nextStep ()
	{
		final LinkedList<Triangle> newTriangleListPointsToAdd = new LinkedList<Triangle> ();

		final LinkedList<Triangle> triangleList = this.triangles.peek ();
		for ( final Triangle triangle : triangleList )
		{
			final int[] triangleX = triangle.getPointsX ();
			final int[] triangleY = triangle.getPointsY ();

			final Point bottomMiddle = new Point ( triangleX[ 0 ], triangleY[ 1 ] );
			final Point leftMiddle = new Point ( ( ( triangleX[ 0 ] + triangleX[ 1 ] ) / 2 ),
					( ( triangleY[ 1 ] + triangleY[ 0 ] ) / 2 ) );
			final Point rightMiddle = new Point ( ( ( triangleX[ 2 ] + triangleX[ 0 ] ) / 2 ),
					( ( triangleY[ 2 ] + triangleY[ 0 ] ) / 2 ) );

			newTriangleListPointsToAdd
					.add ( new Triangle ( new Point ( triangleX[ 0 ], triangleY[ 0 ] ), leftMiddle, rightMiddle ) );

			newTriangleListPointsToAdd
					.add ( new Triangle ( leftMiddle, new Point ( triangleX[ 1 ], triangleY[ 1 ] ), bottomMiddle ) );

			newTriangleListPointsToAdd
					.add ( new Triangle ( rightMiddle, bottomMiddle, new Point ( triangleX[ 2 ], triangleY[ 2 ] ) ) );
		}

		this.triangles.push ( newTriangleListPointsToAdd );
	}

	@Override
	public void lastStep ()
	{
		if ( this.triangles.size () <= 1 )
		{
			return;
		}

		this.triangles.pop ();
	}

	@Override
	public String getFractalName ()
	{
		return "Sierpinski Triangle";
	}
}
