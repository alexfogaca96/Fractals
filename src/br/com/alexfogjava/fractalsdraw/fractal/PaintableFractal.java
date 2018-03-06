package br.com.alexfogjava.fractalsdraw.fractal;

import javax.swing.JComponent;

public abstract class PaintableFractal extends JComponent implements Fractal
{
	private static final long serialVersionUID = -1912852320718281754L;

	public abstract String getFractalName ();
}
