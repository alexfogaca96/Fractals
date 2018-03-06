package br.com.alexfogjava.fractalsdraw;

import java.util.Scanner;

import javax.swing.JFrame;

import br.com.alexfogjava.fractalsdraw.models.SierpinskiTriangle;

public class Main
{
	private static final int FRAME_X_SIZE = 800;
	private static final int FRAME_Y_SIZE = 800;

	public static void main ( final String[] args )
	{
		final Main mainClass = new Main ();

		Main.drawCanvas ( mainClass );
	}

	static void drawCanvas ( final Main mainClass )
	{
		final FrameHolder frame = mainClass.new FrameHolder ( Main.FRAME_X_SIZE, Main.FRAME_Y_SIZE );

		frame.setVisible ( true );
		frame.updateUI ();
	}

	public class FrameHolder extends JFrame
	{
		private static final long serialVersionUID = 3949311167678185748L;

		private final PaintingPanel panel;
		private final String fractalName;

		public FrameHolder ( final int xSize, final int ySize )
		{
			final int offsetBothSides = 20;

			this.panel = new PaintingPanel (
					new SierpinskiTriangle ( xSize - offsetBothSides, ySize - offsetBothSides ), offsetBothSides / 2 );

			this.fractalName = this.panel.toString ();

			this.getContentPane ().add ( this.panel );
			this.initUI ( xSize, ySize );
		}

		private void initUI ( final int xSize, final int ySize )
		{
			this.setSize ( xSize, ySize );
			this.setTitle ( "Fractal - " + this.fractalName );
			this.setLocationRelativeTo ( null );
			this.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );

		}

		private void updateUI ()
		{
			final Scanner sc = new Scanner ( System.in );
			String line = sc.nextLine ();

			while ( !line.equals ( "" ) )
			{
				if ( line.equals ( "next" ) )
				{
					this.panel.nextStep ();
				}

				if ( line.equals ( "last" ) )
				{
					this.panel.lastStep ();
				}

				line = sc.nextLine ();
			}

			sc.close ();
		}

	}
}
