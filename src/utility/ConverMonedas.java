package utility;

public class ConverMonedas {
	private Monedas from;
	private Monedas to;
	
	public ConverMonedas(Monedas from, Monedas to) {
		super();
		this.from = from;
		this.to = to;
	}
	
	public double convertir() {
		double MonedaConvertida = 0.0;
		switch (from.getNombre()) {
		case "Peso": 
			if (to.getNombre().equals("Dolar")) {
				MonedaConvertida = from.getCantidad() * 0.0050 ; 
			} else if(to.getNombre().equals("Euro")) { 
				MonedaConvertida = from.getCantidad() * 0.0047;
			}else  if(to.getNombre().equals("Libras")) {
				MonedaConvertida = from.getCantidad() * 0.0042;
			}else if(to.getNombre().equals("Yen")) {
				MonedaConvertida = from.getCantidad() * 1.47;
			}else
				MonedaConvertida = from.getCantidad() * 6.62;
			break;
		case "Dolar":
			if (to.getNombre().equals("Peso")) {
				MonedaConvertida = from.getCantidad() * 200.38 ; 
			} else if(to.getNombre().equals("Euro")) { 
				MonedaConvertida = from.getCantidad() * 0.94;
			}else  if(to.getNombre().equals("Libras")) {
				MonedaConvertida = from.getCantidad() * 0.84;
			}else if(to.getNombre().equals("Yen")) {
				MonedaConvertida = from.getCantidad() * 136.12;
			}else
				MonedaConvertida = from.getCantidad() * 1325.84;
			break;
		case "Euro":
			if (to.getNombre().equals("Peso")) {
				MonedaConvertida = from.getCantidad() * 211.96 ; 
			} else if(to.getNombre().equals("Dolar")) { 
				MonedaConvertida = from.getCantidad() * 1.06;
			}else  if(to.getNombre().equals("Libras")) {
				MonedaConvertida = from.getCantidad() *0.89;
			}else if(to.getNombre().equals("Yen")) {
				MonedaConvertida = from.getCantidad() *144.04;
			}else
				MonedaConvertida = from.getCantidad() *1402.81;
			break;
		case "Libras":
			if(to.getNombre().equals("Peso")){
				MonedaConvertida = from.getCantidad() * 238.87 ; 
			} else if(to.getNombre().equals("Dolar")) { 
				MonedaConvertida = from.getCantidad() * 1.19;
			}else  if(to.getNombre().equals("Yen")) {
				MonedaConvertida = from.getCantidad() * 162.31;
			}else if(to.getNombre().equals("Euro")) {
				MonedaConvertida = from.getCantidad() *1.13;
			}else
				MonedaConvertida = from.getCantidad() *1581.12;
			break;
		case "Yen":
			if (to.getNombre().equals("Peso")) {
				MonedaConvertida = from.getCantidad() *1.47 ; 
			} else if(to.getNombre().equals("Euro")) { 
				MonedaConvertida = from.getCantidad() * 0.0069;
			}else  if(to.getNombre().equals("Dolar")) {
				MonedaConvertida = from.getCantidad() * 0.0073;
			}else if(to.getNombre().equals("Libras")) {
				MonedaConvertida = from.getCantidad() * 0.0062;
			}else
				MonedaConvertida = from.getCantidad() *9.74;
			break;
		case "Won":
			if (to.getNombre().equals("Peso")) {
				MonedaConvertida = from.getCantidad() * 0.15 ; 
			} else if(to.getNombre().equals("Euro")) { 
				MonedaConvertida = from.getCantidad() * 0.00071;
			}else  if(to.getNombre().equals("Dolar")) {
				MonedaConvertida = from.getCantidad() *0.00075;
			}else if(to.getNombre().equals("Yen")) {
				MonedaConvertida = from.getCantidad() *0.10;
			}else
				MonedaConvertida = from.getCantidad() * 0.00063;
			default:
			break;
			
			
			
			
		}
		return MonedaConvertida;
	}

	public Monedas getFrom() {
		return from;
	}

	public void setFrom(Monedas from) {
		this.from = from;
	}

	public Monedas getTo() {
		return to;
	}

	public void setTo(Monedas to) {
		this.to = to;
	}
	
	
	
}