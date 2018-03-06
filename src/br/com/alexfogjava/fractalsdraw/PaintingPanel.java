package br.com.alexfogjava.fractalsdraw;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.alexfogjava.fractalsdraw.fractal.PaintableFractal;

public class PaintingPanel extends JPanel
{
	private static final long serialVersionUID = -1365696680980662969L;

	private final PaintableFractal fractal;

	public PaintingPanel ( final PaintableFractal fractal, final int offset )
	{
		this.setBorder ( new EmptyBorder ( offset, offset, offset, offset ) );
		this.fractal = fractal;
		this.add ( fractal );
	}

	public void nextStep ()
	{
		this.fractal.nextStep ();
		this.fractal.repaint ();
	}

	public void lastStep ()
	{
		this.fractal.lastStep ();
		this.fractal.repaint ();
	}

	@Override
	public String toString ()
	{
		return "Fractal - " + this.fractal.getFractalName ();
	}
}
