package br.com.api.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dto.ServerStatusDto;

@RestController
public class ServerStatusController {

	@GetMapping("/ServerStatus")
	public ServerStatusDto retornarServerStatus() {

		String dividirDataHora[];
		String dividirHoraMinutoSegundo[];
		String horaMinutoSegundo;
		String hora;
		String minuto;
		String segundo;
		String horaMinutoSegundoSTR;
		int horaInteiro;
		int horaMinutoSegundoInteiro;

		ServerStatusDto serverStatusDto = new ServerStatusDto();
		serverStatusDto.setAviso(false);

		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String date = formatter.format(localDateTime);

		/*
		 * tratamento para verificaro horário de trabalho
		 */
		dividirDataHora = date.split(" ");
		horaMinutoSegundo = dividirDataHora[1];

		dividirHoraMinutoSegundo = horaMinutoSegundo.split(":");
		hora = dividirHoraMinutoSegundo[0];
		minuto = dividirHoraMinutoSegundo[1];
		segundo = dividirHoraMinutoSegundo[2];

		horaInteiro = Integer.valueOf(hora);

		if ((horaInteiro >= 07) && (horaInteiro < 18)) {
			serverStatusDto.setLiberado(true);
		} else {
			serverStatusDto.setLiberado(false);
		}
		
		serverStatusDto.setDate(date);

		/*
		 * tratamento para exibir alerta de encerramento do dia de trabalho para o
		 * usuário
		 */
		if (serverStatusDto.getLiberado()) {
			StringBuilder stringBuilderHora = new StringBuilder();
			stringBuilderHora.append(hora);
			stringBuilderHora.append(minuto);
			stringBuilderHora.append(segundo);
			horaMinutoSegundoSTR = stringBuilderHora.toString();

			horaMinutoSegundoInteiro = Integer.valueOf(horaMinutoSegundoSTR);

			if (horaMinutoSegundoInteiro >= 175500 && horaMinutoSegundoInteiro <= 175959) {
				serverStatusDto.setAviso(true);
			}

		}
/*
		// Recuperando o dia da semana caso final de semana sistema não funciona
		LocalDateTime localdia = LocalDateTime.now();
		String dia = formatter.format(localdia);
		formatter = DateTimeFormatter.ofPattern("EEEE");
		dia = formatter.format(localDateTime);

		if (dia.equals("Sabado") || dia.equals("Domingo")) {
			serverStatusDto.setLiberado(false);
			serverStatusDto.setAviso(false);
		}
*/
		return serverStatusDto;
	}

}
