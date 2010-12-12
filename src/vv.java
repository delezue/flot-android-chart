import java.awt.Color;
import java.util.Vector;

import javax.swing.JFrame;

import com.flotandroidchart.flot.FlotDraw;
import com.flotandroidchart.flot.Options;
import com.flotandroidchart.flot.data.AxisData;
import com.flotandroidchart.flot.data.PointData;
import com.flotandroidchart.flot.data.SeriesData;
import com.flotandroidchart.flot.options.Axies;
import com.flotandroidchart.flot.options.ColorHelper;
import com.flotandroidchart.global.*;

public class vv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ColorHelper c = new ColorHelper(0xffffdd);
		System.out.print(c._r + "" + c._b);

		Vector<SeriesData> sds = new Vector<SeriesData>();
		SeriesData sd = new SeriesData();
		Vector<PointData> pds = new Vector<PointData>();
		for(double i=0; i < Math.PI * 2; i+=0.25) {
			pds.add(new PointData(i, Math.sin(i)));
		}
		sd.setData(pds);
		sd.label = "sin(x)";
		sds.add(sd);		 
		

		SeriesData sd1 = new SeriesData();
		Vector<PointData> pds1 = new Vector<PointData>();
		for(double i=0; i < Math.PI * 2; i+=0.25) {
			pds1.add(new PointData(i, Math.cos(i)));
		}
		sd1.setData(pds1);
		sd1.label = "cos(x)";
		sds.add(sd1);
		
		SeriesData sd2 = new SeriesData();
		Vector<PointData> pds2 = new Vector<PointData>();
		for(double i=0; i < Math.PI * 2; i+=0.1) {
			pds2.add(new PointData(i, Math.tan(i)));
		}
		sd2.setData(pds2);
		sd2.label = "tan(x)";
		sds.add(sd2);		
		
		Options opt = new Options();
		

		FlotDraw fd = new FlotDraw(null, sds, opt, null);

		FlotFrame f = new FlotFrame(fd);
		f.setBounds(0, 0, 320, 480);
		JFrame frame = new JFrame();
		frame.add(f);
		frame.setBounds(0, 0, 320, 500);
		frame.setVisible(true);
		Object dd = new Double(33.0);

		System.out.println((dd instanceof Double) + "Max:"
				+ fd.getAxes().xaxis.datamax);

		AxisData ad = fd.axisSpecToRealAxis(new Axies(), "xaxis");

		System.out.println(ad.datamax);

		// TODO Auto-generated method stub
		EventHolder v = new EventHolder();
		FlotEventListener _l = new FlotEventListener() {

			@Override
			public String Name() {
				// TODO Auto-generated method stub
				return FlotEvent.FLOTEVENT_ADD;
			}

			@Override
			public void execute(FlotEvent event) {
				// TODO Auto-generated method stub
				System.out.print("Trig");
			}

		};
		v.addEventListener(_l);
		System.out.print("add");
		v.dispatchEvent(FlotEvent.FLOTEVENT_ADD, new FlotEvent(v));
		v.dispatchEvent("vv", new FlotEvent(v));
		v.dispatchEvent(FlotEvent.FLOTEVENT_ADD, new FlotEvent(v));
		v.removeEventListener(_l);
		v.dispatchEvent(FlotEvent.FLOTEVENT_ADD, new FlotEvent(v));
		v.dispatchEvent(FlotEvent.FLOTEVENT_ADD, new FlotEvent(v));
	}

}