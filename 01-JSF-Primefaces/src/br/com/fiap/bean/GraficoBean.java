package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import br.com.fiap.bo.ClienteBO;

@ManagedBean
public class GraficoBean {

	private PieChartModel pizza;
	
	private LineChartModel linha;
	
	private ClienteBO bo;
	
	@PostConstruct
	private void init(){
		pizza = new PieChartModel();
		bo = new ClienteBO();
		pizza.set("Ótimo", bo.buscarPorRating(10));
		pizza.set("Regular", bo.buscarPorRating(5));
		pizza.set("Ruim", bo.buscarPorRating(1));
		
		pizza.setShowDataLabels(true);
		pizza.setLegendPosition("e");
		
		//Gráfico de linha
		linha = new LineChartModel();
		linha.setLegendPosition("e");
		linha.getAxes().put(AxisType.X, new CategoryAxis("Meses"));
		
		//Criar um linha no gráfico
		LineChartSeries serie = new LineChartSeries();
		serie.setLabel("Cliente");
		
		for (int i =1 ; i <= 12; i++){
			serie.set(i, bo.contarPorMes(i));
		}
		
		linha.addSeries(serie);
	}

	public PieChartModel getPizza() {
		return pizza;
	}

	public void setPizza(PieChartModel pizza) {
		this.pizza = pizza;
	}

	public LineChartModel getLinha() {
		return linha;
	}

	public void setLinha(LineChartModel linha) {
		this.linha = linha;
	}
}
