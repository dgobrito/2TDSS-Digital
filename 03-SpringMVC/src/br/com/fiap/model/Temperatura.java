package br.com.fiap.model;

public enum Temperatura {

	FRIA("Fria"), QUENTE("Quente"), AMBIENTE("Ambiente");
	
	private final String label;

	private Temperatura(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
