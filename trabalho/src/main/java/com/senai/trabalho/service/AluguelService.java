package com.senai.trabalho.service;

import com.senai.trabalho.model.Aluguel;
import com.senai.trabalho.model.Cliente;
import com.senai.trabalho.model.Veiculo;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class AluguelService {

    private final List<Aluguel> alugueis = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(1);

    // Lista todos os aluguéis cadastrados no sistema
    public List<Aluguel> listarTodos() {
        return alugueis;
    }

    // Busca um aluguel pelo ID
    public Optional<Aluguel> buscarPorId(Long id) {
        return alugueis.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    // Registra um novo aluguel, associando um cliente e um veículo
    // O veículo é marcado como indisponível e o valor total é calculado com base nos dias de aluguel
    public Aluguel registrarAluguel(Cliente cliente, Veiculo veiculo, Aluguel aluguel) {
        if (!veiculo.isDisponivel()) {
            throw new IllegalArgumentException("Veículo não disponível para aluguel.");
        }

        aluguel.setId(contadorId.getAndIncrement());
        aluguel.setCliente(cliente);
        aluguel.setVeiculo(veiculo);

        // Calcula o número de dias entre as datas de início e fim do aluguel
        long dias = ChronoUnit.DAYS.between(aluguel.getDataInicio(), aluguel.getDataFim());
        aluguel.setValorTotal(calcularValorAluguel(veiculo, dias));

        veiculo.setDisponivel(false); // Marca o veículo como indisponível
        alugueis.add(aluguel);
        return aluguel;
    }

    // Calcula o valor total do aluguel com base na categoria do veículo e nos dias de aluguel
    private double calcularValorAluguel(Veiculo veiculo, long dias) {
        double tarifaPorDia = switch (veiculo.getCategoria().toLowerCase()) {
            case "luxo" ->
                200.0;
            case "suv" ->
                150.0;
            default ->
                100.0; // Categoria econômica por padrão
        };
        return dias * tarifaPorDia;
    }

    // Finaliza o aluguel, tornando o veículo disponível novamente
    public void finalizarAluguel(Long id) {
        buscarPorId(id).ifPresent(aluguel -> aluguel.getVeiculo().setDisponivel(true));
    }
}
