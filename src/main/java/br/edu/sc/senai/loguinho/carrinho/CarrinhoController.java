package br.edu.sc.senai.loguinho.carrinho;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

@Controller
final class CarrinhoController {

	private final CarrinhoRepository carrinhoRepository;

	CarrinhoController(final CarrinhoRepository carrinhoRepository) {
		this.carrinhoRepository = carrinhoRepository;
	}

	private static void updateEntityFromDTO(final CarrinhoDTO carrinhoDTO, final CarrinhoEntity carrinhoEntity) {
		carrinhoEntity.setId(carrinhoDTO.getId());;
		carrinhoEntity.setValor_unitario(carrinhoDTO.getValor_unitario());
		carrinhoEntity.setValor_frete(carrinhoDTO.getValor_frete());
		carrinhoEntity.setTotal_pedido(carrinhoDTO.getTotal_pedido());
		carrinhoEntity.setQuantidade(carrinhoDTO.getQuantidade());
		carrinhoEntity.setProduto_id(carrinhoDTO.getProduto_id());
	}

	private static CarrinhoEntity toEntity(final CarrinhoDTO carrinhoDTO) {
		final long id = carrinhoDTO.getId();
		final double valor_unitario = carrinhoDTO.getValor_unitario();
		final double valor_frete = carrinhoDTO.getValor_frete();
		final double total_pedido = carrinhoDTO.getTotal_pedido();
		final int quantidade = carrinhoDTO.getQuantidade();
		final long produto_id = carrinhoDTO.getProduto_id();
		return new CarrinhoEntity(id, valor_unitario,valor_frete, total_pedido, quantidade, produto_id);
				
	}

	private static CarrinhoDTO toDTO(final CarrinhoEntity carrinhoEntity) {

		final long id = carrinhoEntity.getId();
		final double valor_unitario = carrinhoEntity.getValor_unitario();
		final double valor_frete = carrinhoEntity.getValor_frete();
		final double total_pedido = carrinhoEntity.getTotal_pedido();
		final int quantidade = carrinhoEntity.getQuantidade();
		final long produto_id = carrinhoEntity.getProduto_id();
		return new CarrinhoDTO(id,valor_unitario, valor_frete, total_pedido, quantidade, produto_id);
	}

	/*private boolean isNotExistsProductByIdentifier(final Long id) {
		// TODO Auto-generated method stub
		return !this.carrinhoRepository.existsById(id);
	}*/

	List<CarrinhoDTO> getAllCarrinho() {
		final List<CarrinhoDTO> carrinhoDTO = new ArrayList<>();
		this.carrinhoRepository.findAll().forEach(carrinhoEntity -> carrinhoDTO.add(CarrinhoController.toDTO(carrinhoEntity)));
		return carrinhoDTO;
	}

	CarrinhoDTO getCarrinho(final Long id) {
		final Optional<CarrinhoEntity> optionalCarrinho = this.carrinhoRepository.findById(id);
		if (optionalCarrinho.isPresent()) {
			return CarrinhoController.toDTO(optionalCarrinho.get());
		}
		return CarrinhoDTO.NULL_VALUE;
	}

	CarrinhoDTO removeCarrinho(final Long id) {
		final Optional<CarrinhoEntity> optionalCarrinho = this.carrinhoRepository.findById(id);
		if (optionalCarrinho.isPresent()) {
			final CarrinhoEntity carrinhoEntity = optionalCarrinho.get();
			this.carrinhoRepository.delete(carrinhoEntity);
			return CarrinhoController.toDTO(carrinhoEntity);
		}
		return CarrinhoDTO.NULL_VALUE;
	}

	Long insertCarrinho(final CarrinhoDTO carrinhoDTO) {
		final CarrinhoEntity carrinhoEntity = CarrinhoController.toEntity(carrinhoDTO);
		this.carrinhoRepository.save(carrinhoEntity);
		return carrinhoEntity.getId();
	}

	CarrinhoDTO updateCarrinho(final Long id, final CarrinhoDTO carrinhoDTO) {
		final Optional<CarrinhoEntity> optionalCarrinho = this.carrinhoRepository.findById(id);
		if (optionalCarrinho.isPresent()) {
			final CarrinhoEntity carrinhoEntity = optionalCarrinho.get();
			final CarrinhoDTO oldCarrinho = CarrinhoController.toDTO(carrinhoEntity);
			CarrinhoController.updateEntityFromDTO(carrinhoDTO, carrinhoEntity);
			this.carrinhoRepository.save(carrinhoEntity);
			return oldCarrinho;
		}
		return CarrinhoDTO.NULL_VALUE;
		
	}

}
