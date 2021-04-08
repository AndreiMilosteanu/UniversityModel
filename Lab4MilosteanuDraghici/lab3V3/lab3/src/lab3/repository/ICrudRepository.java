//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package lab3.repository;

public interface ICrudRepository<E> {
    E findOne(Long var1);

    Iterable<E> findAll();

    E save(E var1);

    E delete(Long var1);

    E update(E var1);
}
