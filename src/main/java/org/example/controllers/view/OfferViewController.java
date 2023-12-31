package org.example.controllers.view;

import jakarta.validation.Valid;
import org.example.services.BrandService;
import org.example.services.ModelService;
import org.example.services.OfferService;
import org.example.services.OfferViewCounterService;
import org.example.services.UserService;
import org.example.services.dtos.input.OfferDTO;
import org.example.services.dtos.output.OfferFullDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.security.Principal;

@Controller
public class OfferViewController {

    private static final Logger LOG = LogManager.getLogger(Controller.class);
    private OfferService offerService;
    private BrandService brandService;
    private ModelService modelService;
    private UserService userService;
    private OfferViewCounterService offerViewCounterService;
    @Autowired
    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }
    @Autowired
    public void setOfferService(OfferService offerService) {
        this.offerService = offerService;
    }
    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setOfferViewController(OfferViewCounterService offerViewCounterService) {
        this.offerViewCounterService = offerViewCounterService;
    }

    @ModelAttribute("offerDto")
    public OfferDTO initCompany() {
        return new OfferDTO();
    }

    @GetMapping("/offer/search")
    public String showSearchOfferPage(Model model) {
        return "offers-search";
    }

    @GetMapping("/offer/view/{id}")
    public String offerDetails(@PathVariable("id") String id, Model model, Principal principal){
        // Получаем предложение
        OfferFullDetailsDTO offer = offerService.getOfferFullDetailsById(id);
        model.addAttribute("offer", offer);

        // Инкрементируем и получаем количество просмотров
        Long viewCount = offerViewCounterService.incrementAndGetViews(id);

        model.addAttribute("viewCount", viewCount);

        String currentUserId = principal != null ? userService.getUserByUsername(principal.getName()).getId() : null;
        model.addAttribute("currentUserId", currentUserId);

        return "offer-details";
    }

    @GetMapping("/offer/add")
    public String showAddOfferPage(Model model){
        model.addAttribute("OfferDTO", new OfferDTO());
        model.addAttribute("models",modelService.findAll());
        model.addAttribute("users",userService.findAll());
        return "offer-add";
    }

    @PostMapping("/offer/add")
    public String addOffer(@Valid OfferDTO offerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerDto", offerDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerDto", bindingResult);
            System.out.println(offerDto);
            return "redirect:/offer/add";
        }
        offerDto.setSeller_id(userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getId());
        offerDto = offerService.createOffer(offerDto);
        String logMessage = String.format("User %s has added offer %s.", SecurityContextHolder.getContext().getAuthentication().getName(), offerDto.getId());
        LOG.log(Level.INFO, logMessage);
        return "redirect:/home";
    }

    @GetMapping("/offer/edit/{id}")
    public String showEditOfferPage(@PathVariable("id") String id, Model model) {
        OfferDTO offer = offerService.getOfferById(id);
        model.addAttribute("offer", offer);
//        System.out.println(offer.toString());
        model.addAttribute("models",modelService.findAll());
        model.addAttribute("users",userService.findAll());
        return "offer-edit";
    }

    @PostMapping("/offer/edit/{id}")
    public String editOffer(@PathVariable("id") String id, @Valid OfferDTO offerDto, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            System.out.println(offerDto);
            offerDto.setSeller_id(offerService.getOfferById(offerDto.getId()).getSeller_id());
            System.out.println(offerService.getOfferById(offerDto.getId()));
            System.out.println(offerDto);
            redirectAttributes.addFlashAttribute("offerDto", offerDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerDto", bindingResult);
            return "redirect:/offer/edit/" + id;
        }
        System.out.println(offerDto);
        offerDto.setSeller_id(offerService.getOfferById(offerDto.getId()).getSeller_id());
        System.out.println(offerDto);
        offerDto = offerService.editOffer(id, offerDto);
        String logMessage = String.format("User %s has edited offer %s.", SecurityContextHolder.getContext().getAuthentication().getName(), offerDto.getId());
        LOG.log(Level.INFO, logMessage);
        return "redirect:/home";
    }

    @GetMapping("/offer/delete/{id}")
    public String showDeleteOfferPage(@PathVariable("id") String id, Model model) {
        offerService.deleteOffer(id);
        String logMessage = String.format("User %s has deleted offer %s.", SecurityContextHolder.getContext().getAuthentication().getName(), id);
        LOG.log(Level.INFO, logMessage);
        return "redirect:/home";
    }

}
