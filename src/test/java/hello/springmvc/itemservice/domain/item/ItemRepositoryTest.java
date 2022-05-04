package hello.springmvc.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {

    private ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void clear() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Item item = new Item("item1", 10, 10);

        // when
        Item save = itemRepository.save(item);

        // then
        Item findItem = itemRepository.findById(save.getId());
        assertThat(findItem).isEqualTo(save);
    }

    @Test
    void findAll() {
        // given
        Item item1 = new Item("item1", 10, 10);
        Item item2 = new Item("item2", 10, 10);

        // when
        itemRepository.save(item1);
        itemRepository.save(item2);

        // then
        List<Item> all = itemRepository.findAll();
        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(item1, item2);
    }

    @Test
    void findById() {
    }
}