import net.jqwik.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;

public class LeftistHeapTest {

    @Provide
    Arbitrary<List<Integer>> first(){
        return Arbitraries.integers().list();
    }

    @Property
    void listheap_isnt_empty(@ForAll("first")List<Integer> any_ints){
        LeftistHeap lh = new LeftistHeap();
        for(int i : any_ints){
            lh.insert(i);
        }

        lh.insert(0);
        assertThat(lh.isEmpty()).isFalse();
    }

    @Property
    void listheap_is_empty(@ForAll("first")List<Integer> any_ints){
        LeftistHeap lh = new LeftistHeap();
        for(int i : any_ints){
            lh.insert(i);
        }
        lh.clear();
        assertThat(lh.isEmpty()).isTrue();
    }

    @Property
    void listheap_is_empty_after_manual_remove(@ForAll("first")List<Integer> any_ints){
        LeftistHeap lh = new LeftistHeap();
        for(int i : any_ints){
            lh.insert(i);
        }
        for(int i = 0; i < any_ints.size(); i++){
            lh.deleteMin();
        }
        assertThat(lh.isEmpty()).isTrue();
    }

    @Example
    void listheap_delete_empty(){
        LeftistHeap lh = new LeftistHeap();
        assertThat(lh.deleteMin() == -1).isTrue();
    }

    @Example
    void listheap_simple_pair_insert(){
        LeftistHeap lh = new LeftistHeap();
        lh.insert(1);
        lh.insert(0);

        assertThat(lh.inorder()).isEqualTo("1 0 ");
    }

    @Property
    void listheap_sort(@ForAll("first")List<Integer> any_ints){
        LeftistHeap lh = new LeftistHeap();
        for(int i : any_ints){
            lh.insert(i);
        }

        any_ints.sort(Comparator.naturalOrder());

        for (int i = 0; i < any_ints.size(); i++) {
            assertThat(lh.deleteMin()).isEqualTo(any_ints.get(i));
        }

    }

}
