package question1;

public class PatternObservateur extends junit.framework.TestCase {

    public void testNotify() {
        ConcreteSubject list;
        ConcreteObserver observer;

        list = new ConcreteSubject();           // création d'un "observé" constitué d'une liste
        observer = new ConcreteObserver();      // création d'un observateur
        list.addObserver(observer);             // ajouter cet observateur à la liste
        list.insert("il fait beau, ce matin");  // modification de cette liste, l'observateur doit
                                                // (dervrait) être notifié

        // "vérification" :
        assertFalse(observer.senders().empty());                            // elle ne doit pas être vide,
        assertEquals(list, observer.senders().pop());                       // est-ce le bon émetteur ?
        assertEquals("il fait beau, ce matin", observer.arguments().pop()); // le paramètre reçu est-il correct ?
    }

    // une liste, 2 observateurs
    public void test1() {
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        question1.ConcreteObserver o1 = new question1.ConcreteObserver();
        question1.ConcreteObserver o2 = new question1.ConcreteObserver();
        l1.addObserver(o1);
        l1.addObserver(o2);
        l1.insert("test");
        l1.insert(" 1 ");
        assertEquals(l1,o1.senders().pop() );
        assertEquals(l1,o2.senders().pop());
        assertEquals(l1,o1.senders().pop() );
        assertEquals(l1,o2.senders().pop());
        assertTrue(o1.arguments().pop().equals(" 1 "));
        assertTrue(o1.arguments().pop().equals("test"));
         assertTrue(o2.arguments().pop().equals(" 1 "));
        assertTrue(o2.arguments().pop().equals("test"));
        assertTrue(o1.senders().empty() && o1.arguments().empty());
         
        assertTrue(o2.senders().empty() && o2.arguments().empty());
        
    }

    // deux listes, 1 observateur
    public void test2() {
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        question1.ConcreteSubject l2 = new question1.ConcreteSubject();

        question1.ConcreteObserver o = new question1.ConcreteObserver();
        l1.addObserver(o);
        l2.addObserver(o);
        l1.insert("testA");
        l1.insert(" A ");
        l2.insert("testB");
        l2.insert(" B ");

        assertEquals(l2,o.senders().pop());
        assertEquals(l2,o.senders().pop());
        assertTrue(o.arguments().pop().equals(" B "));
        assertTrue(o.arguments().pop().equals("testB"));
        assertEquals(l1,o.senders().pop());
        assertEquals(l1,o.senders().pop());
        assertTrue(o.arguments().pop().equals(" A "));
        assertTrue(o.arguments().pop().equals("testA"));
        assertTrue(o.senders().empty() && o.arguments().empty());
    }

    // deux listes, 2 observateurs
    public void test3() {
        question1.ConcreteSubject l1 = new question1.ConcreteSubject();
        question1.ConcreteSubject l2 = new question1.ConcreteSubject();
        question1.ConcreteObserver o1 = new question1.ConcreteObserver();
        question1.ConcreteObserver o2 = new question1.ConcreteObserver();
        l1.addObserver(o1);
        l1.addObserver(o2);
        l2.addObserver(o1);
        l2.addObserver(o2);
        l1.insert("A");
        l2.insert("B");
        

        assertEquals(l2,o1.senders().pop());
        assertEquals(l2,o2.senders().pop());
        assertTrue(o1.arguments().pop().equals("B"));
        assertTrue(o2.arguments().pop().equals("B"));
        assertEquals(l1,o1.senders().pop());
        assertEquals(l1,o2.senders().pop());
        assertTrue(o1.arguments().pop().equals("A"));
        assertTrue(o2.arguments().pop().equals("A"));
        l1.deleteObservers();
        l2.deleteObservers();
        assertTrue(o1.senders().empty());
        assertTrue(o2.senders().empty());
        assertTrue(l1.countObservers() == 0);
        assertTrue(l2.countObservers() == 0);
    }
    
}
