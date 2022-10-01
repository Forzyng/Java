package com.itstep.firstspring.controllers.portfolio;

import com.itstep.firstspring.entities.portfolio.PortfolioItem;
import com.itstep.firstspring.repos.Portfolio.PortfolioCategoryRepository;
import com.itstep.firstspring.repos.Portfolio.PortfolioItemRepository;
import com.itstep.firstspring.repos.Portfolio.PortfolioTagRepository;
import com.itstep.firstspring.storage.services.StorageService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@Controller
public class PortfolioItemController {
    private final PortfolioItemRepository itemRepository;
    private final PortfolioCategoryRepository categoryRepository;
    private final PortfolioTagRepository tagRepository;

    private final StorageService storageService;

    public PortfolioItemController(
            PortfolioItemRepository itemRepository,
            PortfolioCategoryRepository categoryRepository,
            PortfolioTagRepository tagRepository,
            StorageService storageService
    ) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
        this.storageService = storageService;
    }


    /**
     * Вывод на экран всех портфолио
     * @param model
     * @return
     */
    @GetMapping("/portfolio")
    public String index(Model model){
        model.addAttribute("portfolios", itemRepository.findAll());
        return "portfolio/index";
    }

    /**
     * Вывод формы для создания новой сущности
     * @return
     */
    @GetMapping("/portfolio/create")
    public String create(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        return "/portfolio/form-create";

    }


    /**
     * Сохранение сущности
     * @param portfolio
     */
    @PostMapping("/portfolio/store")
    public RedirectView store(
            @Param("category_id") long category_id,
            @Param("tags_id") long[] tags_id,
            @Param("file") MultipartFile file,
            PortfolioItem portfolio
    ){
        portfolio.setCategory(categoryRepository.findById(category_id).get());
//        itemRepository.save(portfolio);

        // ArrayList<PortfolioTag> tags = new ArrayList<>();
       /* for (int i = 0; i < tags_id.length; i++)
        {

            portfolio.getTags().add( tagRepository.findById(tags_id[i]).get() );
            //   tags.add(tagRepository.findById(tags_id[i]).get());
        }*/
       // portfolio.getTags().add( tagRepository.findById(tags_id[0]).get() );

        //
        storageService.store(file);
        portfolio.setMainImg(file.getOriginalFilename()); //    ../../../../upload-dir file.getOriginalFilename()
        itemRepository.save(portfolio);
        return new RedirectView("/portfolio");
    }

    @GetMapping("/portfolio/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name="id") Long id
    ){
        PortfolioItem p = itemRepository.findById(id).get();
        model.addAttribute("portfolio", p);
        return "/portfolio/form-update";
    }

    @GetMapping("/portfolio/delete/{id}")
    public RedirectView delete(
            @PathVariable(name="id") Long id
    ) {
        itemRepository.deleteById(id);
        return new RedirectView("/portfolio");
    }

}
