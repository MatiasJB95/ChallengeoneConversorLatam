package utility;

public class ConverDis {
	private Distancias from;
	private Distancias to;
	
	public ConverDis(Distancias from, Distancias to) {
		super();
		this.from = from;
		this.to = to;
	}
	
	public double convertir() { 
		double DistanciaConvertida = 0.0;
		switch (from.getNombre()) {
		case "Kilometros":
			if (to.getNombre().equals("Millas")) {
				DistanciaConvertida = from.getCantidad() / 1.609 ; 
			} else if(to.getNombre().equals("Hectometros")) { 
				DistanciaConvertida = from.getCantidad() * 10;
			}else  DistanciaConvertida = from.getCantidad() / 4.828;
			break;
		case "Millas":
			if (to.getNombre().equals("Kilometros")) {
				DistanciaConvertida = from.getCantidad() * 1.609 ;
			} else if(to.getNombre().equals("Hectometros")) { 
				DistanciaConvertida =(from.getCantidad() * 16.093); 
			}else
				  DistanciaConvertida = from.getCantidad() / 3;
	
			break;
		case "Hectometros":
			if (to.getNombre().equals("Kilometros")) {
				DistanciaConvertida = from.getCantidad() / 10;
			} else if(to.getNombre().equals("Millas")) {
				DistanciaConvertida = (from.getCantidad() / 16.093);
			}else 
				DistanciaConvertida = (from.getCantidad() / 48.28);
			break;
		case "Leguas":
			if(to.getNombre().equals("Kilometros")){
				DistanciaConvertida=(from.getCantidad() * 4.828);
			}else if (to.getNombre().equals("Millas")) {
				 DistanciaConvertida = from.getCantidad() * 3;
			}else 
				DistanciaConvertida = (from.getCantidad() * 48.28);
		default:
			break;
			
			
			
			
			
		}
		return DistanciaConvertida;
	}

	public Distancias getFrom() {
		return from;
	}

	public void setFrom(Distancias from) {
		this.from = from;
	}

	public Distancias getTo() {
		return to;
	}

	public void setTo(Distancias to) {
		this.to = to;
	}
	
	
	
}
