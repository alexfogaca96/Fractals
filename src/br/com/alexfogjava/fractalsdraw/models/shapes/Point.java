package br.com.alexfogjava.fractalsdraw.models.shapes;

public class Point
{
	private int x;
	private int y;

	public Point ( final int x, final int y )
	{
		this.x = x;
		this.y = y;
	}

	public int getX ()
	{
		return this.x;
	}

	public void setX ( final int x )
	{
		this.x = x;
	}

	public int getY ()
	{
		return this.y;
	}

	public void setY ( final int y )
	{
		this.y = y;
	}

	@Override
	public int hashCode ()
	{
		final int prime = 31;
		int result = 1;
		result = ( prime * result ) + this.x;
		result = ( prime * result ) + this.y;
		return result;
	}

	@Override
	public boolean equals ( final Object obj )
	{
		if ( this == obj )
		{
			return true;
		}
		if ( obj == null )
		{
			return false;
		}
		if ( this.getClass () != obj.getClass () )
		{
			return false;
		}
		final Point other = ( Point ) obj;
		if ( this.x != other.x )
		{
			return false;
		}
		if ( this.y != other.y )
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString ()
	{
		return "Point [x=" + this.x + ", y=" + this.y + "]";
	}
}
