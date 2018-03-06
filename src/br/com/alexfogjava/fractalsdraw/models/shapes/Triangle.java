package br.com.alexfogjava.fractalsdraw.models.shapes;

import java.util.Arrays;

public class Triangle
{
	private final Point[] points;

	public Triangle ( final Point top, final Point left, final Point right )
	{
		this.points = new Point[] { top, left, right };
	}

	public Point[] getTriangle ()
	{
		return Arrays.copyOf ( this.points, this.points.length );
	}

	public int[] getPointsX ()
	{
		final int[] pointsX = new int[ 3 ];

		for ( int i = 0; i < 3; i++ )
		{
			pointsX[ i ] = this.points[ i ].getX ();
		}

		return pointsX;
	}

	public int[] getPointsY ()
	{
		final int[] pointsY = new int[ 3 ];

		for ( int i = 0; i < 3; i++ )
		{
			pointsY[ i ] = this.points[ i ].getY ();
		}

		return pointsY;
	}

	public static final int getNumberOfSides ()
	{
		return 3;
	}
}
