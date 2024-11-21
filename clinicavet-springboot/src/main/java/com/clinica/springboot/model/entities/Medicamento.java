package com.clinica.springboot.model.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Medicamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	private Pedido pedido;
	
	private String nome;
	private String laboratorio;
	private Double concentracao;
	private Double preco;

	private Integer quantidade;
	private boolean contrato;

	public Medicamento() {
	}

	public Medicamento(Long id, String nome, String laboratorio, Double concentracao, Double preco, Integer quantidade,
			boolean contrato) {
		super();
		this.id = id;
		this.nome = nome;
		this.laboratorio = laboratorio;
		this.concentracao = concentracao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.contrato = contrato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Double getConcentracao() {
		return concentracao;
	}

	public void setConcentracao(Double concentracao) {
		this.concentracao = concentracao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public boolean isContrato() {
		return contrato;
	}

	public void setContrato(boolean contrato) {
		this.contrato = contrato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medicamento other = (Medicamento) obj;
		return Objects.equals(id, other.id);
	}

}
