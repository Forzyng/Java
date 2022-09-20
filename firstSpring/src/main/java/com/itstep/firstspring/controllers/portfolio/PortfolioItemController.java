package com.itstep.firstspring.controllers.portfolio;

import com.itstep.firstspring.entities.portfolio.PortfolioItem;
import com.itstep.firstspring.repos.Portfolio.PortfolioItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@Controller
public class PortfolioItemController {
    private final PortfolioItemRepository portfolioItemRepository;

    public PortfolioItemController(PortfolioItemRepository portfolioItemRepository) {
        this.portfolioItemRepository = portfolioItemRepository;
    }

    @GetMapping("/portfolio") // Маршрут, по которому будет отвечать данный метод контроллера
    public String contact(Model model){
        model.addAttribute("portfolios", portfolioItemRepository.findAll());
        return "portfolio/index";
    }

    @PostMapping("/portfolio/create")
    public RedirectView createPortfolio(
            PortfolioItem portfolioItem
    )
    {
        portfolioItemRepository.save(portfolioItem);
        return new RedirectView("/portfolio");
    }

    @PutMapping("/portfolio/update/{id}")
    public PortfolioItem updateById(@PathVariable(name = "id") UUID id,
                                    PortfolioItem portfolioItem)
    {
        return portfolioItemRepository.save(portfolioItem);
    }

    @DeleteMapping("/portfolio/delete/{id}")
    public void deleteById(@PathVariable(name = "id") UUID id)
    {
        portfolioItemRepository.deleteById(id);
    }

}
