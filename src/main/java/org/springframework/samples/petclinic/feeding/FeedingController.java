package org.springframework.samples.petclinic.feeding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feeding")
public class FeedingController {

    private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "feedings/createOrUpdateFeedingForm";

    @Autowired
    FeedingService feedingService;

    @Autowired
    PetService petService;
    
    @GetMapping(path = "/create")
	public String initCreationForm(Feeding feeding, ModelMap model) {
		model.put("pets", petService.getAllPets());
        model.put("feedingTypes", feedingService.getAllFeedingTypes());

		return VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
	}
}
