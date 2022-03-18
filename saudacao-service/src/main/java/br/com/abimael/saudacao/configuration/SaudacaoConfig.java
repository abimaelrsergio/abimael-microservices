package br.com.abimael.saudacao.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

// refreshScope pega as mudanças de configuração automáticamente
@RefreshScope
@Component
@ConfigurationProperties("saudacao-service")
public class SaudacaoConfig {

	private String saudacao;
	private String defaultValue;

	public SaudacaoConfig() {
	}

	public SaudacaoConfig(String saudacao, String defaultValue) {
	}

	public String getSaudacao() {
		return saudacao;
	}

	public void setSaudacao(String saudacao) {
		this.saudacao = saudacao;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

}
