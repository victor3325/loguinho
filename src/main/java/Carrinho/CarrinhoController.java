package Carrinho;

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
		carrinhoEntity.setValor_frete(carrinhoDTO.getvalor_Frete());
		carrinhoEntity.setTotal_pedido(carrinhoDTO.getTotal_pedido());
	}

	private static CarrinhoEntity toEntity(final CarrinhoDTO carrinhoDTO) {
		final long id = carrinhoDTO.getId();
		final double valor_unitario = carrinhoDTO.getValor_unitario();
		final double valor_frete = carrinhoDTO.getvalor_Frete();
		final double total_pedido = carrinhoDTO.getTotal_pedido();
		return new CarrinhoEntity(id, valor_unitario,valor_frete, total_pedido);
	}

	private static CarrinhoDTO toDTO(final CarrinhoEntity carrinhoEntity) {

		final long id = carrinhoEntity.getId();
		final double valor_unitario = carrinhoEntity.getValor_unitario();
		final double valor_frete = carrinhoEntity.getValor_frete();
		final double total_pedido = carrinhoEntity.getTotal_pedido();
		return new CarrinhoDTO(id,valor_unitario, valor_frete, total_pedido);
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
