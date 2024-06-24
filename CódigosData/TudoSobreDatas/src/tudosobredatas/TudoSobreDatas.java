package tudosobredatas;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TudoSobreDatas {

    public static void main(String[] args) {
        /*DateTimeFormatter fmt01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt02 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();
        
        //ISO 8601
        LocalDate d04 = LocalDate.parse("2024-02-27");
        LocalDateTime d05 = LocalDateTime.parse("2024-02-27T14:23:09.6374");
        Instant d06 = Instant.parse("2024-02-27T14:34:09.8363Z");
        // Instanciando um horario equivalente a londres 
        Instant d07 = Instant.parse("2024-02-27T14:35:09-03:00");
        // O método parse ele acaita uma sobre carga(outro paramêtro) de como vai interpretar 
        // o texto
        LocalDate d08 = LocalDate.parse("27/02/2024", fmt01);
        LocalDateTime d09 = LocalDateTime.parse("27/02/2024 14:40", fmt02);
        // Dia, mês, ano
        LocalDate d10 = LocalDate.of(2014, 02, 27);
        LocalDateTime d11 = LocalDateTime.of(2024, 02, 27, 14, 50);
        
        
        
        System.out.println("Data local: " + d01);
        System.out.println("Data Hora local: " + d02);
        System.out.println("Data Hora Global(fuso horario): " + d03);
        System.out.println("Data Local(ISO 8601): " + d04);
        System.out.println("Data Hora Local(ISO 8601): " + d05);
        System.out.println("Data Hora Global(fuso horario ISO 8601): " + d06);
        System.out.println("Data Hora Global(colocando um horario de sao paulo e mostrando"
                + "o horario de londres atreves do ISO 8601): " + d07);
        System.out.println("D08: " + d08);
        System.out.println("D09: " + d09);
        System.out.println("D10: " + d10);
        System.out.println("D11: " + d11);
        
        //Vou usar dessa forma no meu PI 
        LocalDate d12 = LocalDate.parse("2024-02-27");
        LocalDateTime d13 = LocalDateTime.parse("2024-02-27T14:40");
        Instant d14 = Instant.parse("2024-02-27T01:30:00Z");
        
        DateTimeFormatter fmt03 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt04 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        // Aqui eu coloco para imprimir o horario conforme o fuso horário do computador do usuário
        DateTimeFormatter fmt05 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt06 = DateTimeFormatter.ISO_DATE;
        
        // Usando ISO_DATE também pode usar o ISO_DATE_TIME etc 
        System.out.println("D12 = " + d12.format(fmt06));
        
        System.out.println("D12 = " + d12.format(fmt03)); 
        // Outra forma de mostrar na tela
        System.out.println("D12 = " + fmt03.format(d12));
        
        // Instanciando a classe quando for mostrar na tela 
        System.out.println("D12 = " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(d12));
        
        System.out.println("D13 = " + d13.format(fmt04)); 
        System.out.println("d14 = " + fmt05.format(d14)); */
        
        
        // Converter hora global para local
        LocalDate d15 = LocalDate.parse("2024-02-27");
        LocalDateTime d16 = LocalDateTime.parse("2024-02-27T14:23:09");
        Instant d17 = Instant.parse("2024-02-27T01:34:09Z");
        
        // Convertendo para o horário da minha máquina 
        LocalDate r1 = LocalDate.ofInstant(d17, ZoneId.systemDefault());
        // Convertendo para o horário de portugal
        LocalDate r2 = LocalDate.ofInstant(d17, ZoneId.of("Portugal"));
        
        LocalDateTime r3 = LocalDateTime.ofInstant(d17, ZoneId.systemDefault());
        LocalDateTime r4 = LocalDateTime.ofInstant(d17, ZoneId.of("Portugal"));
        
        System.out.println("r1 = " + r1);
        System.out.println("r2 = " + r2);
        System.out.println("r3 = " + r3);
        System.out.println("r4 = " + r4);
        System.out.println("");
        
        // Obtendo dados de uma hora local 
        System.out.println("d16 dia = " + d16.getDayOfMonth());
        System.out.println("d16 mes = " + d16.getMonthValue());
        System.out.println("d16 ano = " + d16.getYear());
        System.out.println("d16 hora = " + d16.getHour());
        System.out.println("d16 minutos = " + d16.getMinute());
        System.out.println("d16 segundos = " + d16.getSecond());
        System.out.println("");
        
        // Instanciando uma nova data do d16, com 7 dias a MENOS(atrás)
        LocalDateTime pastWeekLocalDateTime = d16.minusDays(7);
        // Instanciando uma nova data do d16, com 7 dias a MAIS(adiantado)
        LocalDateTime nexteWeekLocalDateTime = d16.plusDays(7);
        // Com local date 
        LocalDate pastWeekLocalDate = d15.minusDays(7);
        // Com instant
        Instant pastWeekInstant = d17.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d17.plus(7, ChronoUnit.DAYS);
        
        System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
        System.out.println("nexteWeekLocalDateTime = " + nexteWeekLocalDateTime);
        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("pastWeekInstant = " + pastWeekInstant);
        System.out.println("nextWeekInstant = " + nextWeekInstant);
        System.out.println("");
        
        // Calcular a durção de uma data a outra
        // Com local date time 
        Duration t1 = Duration.between(pastWeekLocalDateTime, d16);
        // Com local date 
        Duration t2 = Duration.between(pastWeekLocalDate.atStartOfDay(), d15.atStartOfDay());
        // Com instant
        Duration t3 = Duration.between(pastWeekInstant, d17);
        
        System.out.println("t1 = " + t1.toDays());
        System.out.println("t2 = " + t2.toDays());
        System.out.println("t3 = " + t3.toDays());
    }
    
}
