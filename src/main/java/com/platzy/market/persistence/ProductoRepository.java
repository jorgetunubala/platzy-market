package com.platzy.market.persistence;

import com.platzy.market.persistence.crud.ProductoCrudRepository;
import com.platzy.market.persistence.entitys.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(Integer idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<Producto> getProducto(Integer idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto guardarProducto(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void eliminarProducto(Integer idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
