package hello.springmvc.itemservice.web.basic;

import hello.springmvc.itemservice.domain.item.Item;
import hello.springmvc.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/basic/items")
public class BasicItemController {
    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);

        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "basic/item";
    }

    @GetMapping("/add")
    public String add() {
        return "basic/addForm";
    }

//    @PostMapping("/add")
//    public String addPost(@RequestParam String itemName,
//                          @RequestParam int price,
//                          @RequestParam Integer quantity,
//                          Model model) {
//        Item item = new Item(itemName, price, quantity);
//        itemRepository.save(item);
//
//        model.addAttribute("item", item);
//        return "basic/item";
//    }
//
//    @PostMapping("/add")
//    public String addPost(@ModelAttribute("item") Item item) {
//        itemRepository.save(item);
//
//        return "basic/item";
//    }

//    @PostMapping("/add")
//    public String addPost(Item item) {
//        itemRepository.save(item);
//
//        return "redirect:/basic/items/" + item.getId();
//    }

    @PostMapping("/add")
    public String addPost(Item item, RedirectAttributes redirectAttributes) {
        itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", item.getId());
        redirectAttributes.addAttribute("status", true);

        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);

        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, Item item) {
        itemRepository.update(itemId, item);

        return "redirect:/basic/items/{itemId}";
    }

    @PostConstruct
    public void init() {
        itemRepository.save(new Item("item1", 100000, 1));
        itemRepository.save(new Item("item2", 10000, 9));
    }

}
