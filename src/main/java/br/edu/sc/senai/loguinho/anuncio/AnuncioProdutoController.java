package br.edu.sc.senai.loguinho.anuncio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;

import br.edu.sc.senai.loguinho.endereco.EnderecoEntity;


@Controller
public class AnuncioProdutoController {
	
	private final AnuncioProdutoRepository anuncioRepository;

	AnuncioProdutoController(final AnuncioProdutoRepository anuncioRepository) {
		this.anuncioRepository = anuncioRepository;
	}

	private static void updateEntityFromDTO(final AnuncioProdutoDTO anuncioDTO, final AnuncioProdutoEntity anuncioEntity) {
		anuncioEntity.setId(anuncioDTO.getId());
		anuncioEntity.setNome(anuncioDTO.getNome());
		anuncioEntity.setPreco_unit(anuncioDTO.getPreco_unit());
		anuncioEntity.setCategoria(anuncioDTO.getCategoria());
		anuncioEntity.setQuantidade(anuncioDTO.getQuantidade());
		anuncioEntity.setMoeda(anuncioDTO.getMoeda());
		anuncioEntity.setDescricao(anuncioDTO.getDescricao());
		anuncioEntity.setEntrega(anuncioDTO.getEntrega());
		anuncioEntity.setImagem_produto(anuncioDTO.getImagem_produto());
		anuncioEntity.setEndereco(anuncioDTO.getEndereco());
		
	
	}

	private static AnuncioProdutoEntity toEntity(final AnuncioProdutoDTO anuncioDTO) {
		final long id = anuncioDTO.getId();
		final String nome = anuncioDTO.getNome();
	    final double preco_unit = anuncioDTO.getPreco_unit();
	    final int quantidade = anuncioDTO.getQuantidade();
	    final String categoria = anuncioDTO.getCategoria();
	    final String moeda = anuncioDTO.getMoeda();
	    final String entrega = anuncioDTO.getEntrega();
	    final String descricao = anuncioDTO.getDescricao();
	    final String imagem_produto = anuncioDTO.getImagem_produto();
	    final EnderecoEntity endereco =anuncioDTO.getEndereco();
	    
		return new AnuncioProdutoEntity(id, nome, preco_unit, quantidade, categoria, moeda, entrega, descricao, imagem_produto,endereco);
	}

	private static AnuncioProdutoDTO toDTO(final AnuncioProdutoEntity anuncioEntity) {
		final long id = anuncioEntity.getId();
		final String nome = anuncioEntity.getNome();
	    final double preco_unit = anuncioEntity.getPreco_unit();
	    final int quantidade = anuncioEntity.getQuantidade();
	    final String categoria = anuncioEntity.getCategoria();
	    final String moeda = anuncioEntity.getMoeda();
	    final String entrega = anuncioEntity.getEntrega();
	    final String descricao = anuncioEntity.getDescricao();
	    final String imagem_produto = anuncioEntity.getImagem_produto();
	    final EnderecoEntity endereco = anuncioEntity.getEndereco();
		return new AnuncioProdutoDTO(id, nome, preco_unit, quantidade, categoria, moeda, entrega, descricao, imagem_produto,endereco);
		
	}

	/*private boolean isNotExistsProductByIdentifier(final Long id) {
		// TODO Auto-generated method stub
		return !this.anuncioRepository.existsById(id);
	}*/

	List<AnuncioProdutoDTO> getAllProduto() {
		final List<AnuncioProdutoDTO> carrinhoDTO = new ArrayList<>();
		this.anuncioRepository.findAll().forEach(anuncioEntity -> carrinhoDTO.add(AnuncioProdutoController.toDTO(anuncioEntity)));
		return carrinhoDTO;
	}

	AnuncioProdutoDTO getProduto(final Long id) {
		final Optional<AnuncioProdutoEntity> optionalProduto = this.anuncioRepository.findById(id);
		if (optionalProduto.isPresent()) {
			return AnuncioProdutoController.toDTO(optionalProduto.get());
		}
		return AnuncioProdutoDTO.NULL_VALUE;
	}

	AnuncioProdutoDTO removeProdutoDTO(final Long id) {
		final Optional<AnuncioProdutoEntity> optionalProduto = this.anuncioRepository.findById(id);
		if (optionalProduto.isPresent()) {
			final AnuncioProdutoEntity anuncioEntity = optionalProduto.get();
			this.anuncioRepository.delete(anuncioEntity);
			return AnuncioProdutoController.toDTO(anuncioEntity);
		}
		return AnuncioProdutoDTO.NULL_VALUE;
	}

	Long insertProduto(final AnuncioProdutoDTO anuncioDTO) {
		final AnuncioProdutoEntity anuncioEntity = AnuncioProdutoController.toEntity(anuncioDTO);
		this.anuncioRepository.save(anuncioEntity);
		return anuncioEntity.getId();
	}

	AnuncioProdutoDTO updateProduto(final Long id, final AnuncioProdutoDTO anuncioDTO) {
		final Optional<AnuncioProdutoEntity> optionalProduto = this.anuncioRepository.findById(id);
		if (optionalProduto.isPresent()) {
			final AnuncioProdutoEntity anuncioEntity = optionalProduto.get();
			final AnuncioProdutoDTO oldProduto = AnuncioProdutoController.toDTO(anuncioEntity);
			AnuncioProdutoController.updateEntityFromDTO(anuncioDTO, anuncioEntity);
			this.anuncioRepository.save(anuncioEntity);
			return oldProduto;
		}
		return AnuncioProdutoDTO.NULL_VALUE;
		
	}

}
