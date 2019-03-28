package co.edu.usbcali.arquitectura.rest.controllers;

import co.edu.usbcali.arquitectura.dto.mapper.ICategoriaMapper;
import co.edu.usbcali.arquitectura.modelo.*;
import co.edu.usbcali.arquitectura.modelo.dto.CategoriaDTO;
import co.edu.usbcali.arquitectura.presentation.businessDelegate.IBusinessDelegatorView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/categoria")
public class CategoriaRestController {
    private static final Logger log = LoggerFactory.getLogger(CategoriaRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ICategoriaMapper categoriaMapper;

    @PostMapping(value = "/saveCategoria")
    public void saveCategoria(@RequestBody
    CategoriaDTO categoriaDTO) throws Exception {
        try {
            Categoria categoria = categoriaMapper.categoriaDTOToCategoria(categoriaDTO);

            businessDelegatorView.saveCategoria(categoria);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteCategoria/{idCategoria}")
    public void deleteCategoria(@PathVariable("idCategoria")
    Integer idCategoria) throws Exception {
        try {
            Categoria categoria = businessDelegatorView.getCategoria(idCategoria);

            businessDelegatorView.deleteCategoria(categoria);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateCategoria/")
    public void updateCategoria(@RequestBody
    CategoriaDTO categoriaDTO) throws Exception {
        try {
            Categoria categoria = categoriaMapper.categoriaDTOToCategoria(categoriaDTO);

            businessDelegatorView.updateCategoria(categoria);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataCategoria")
    public List<CategoriaDTO> getDataCategoria() throws Exception {
        try {
            return businessDelegatorView.getDataCategoria();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getCategoria/{idCategoria}")
    public CategoriaDTO getCategoria(
        @PathVariable("idCategoria")
    Integer idCategoria) throws Exception {
        try {
            Categoria categoria = businessDelegatorView.getCategoria(idCategoria);

            return categoriaMapper.categoriaToCategoriaDTO(categoria);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
