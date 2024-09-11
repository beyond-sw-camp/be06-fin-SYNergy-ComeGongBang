    package com.synergy.backend.domain.orders.repository;

    import com.synergy.backend.domain.orders.model.entity.Cart;
    import com.synergy.backend.domain.orders.model.response.CartDTO;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;

    import java.util.List;

    public interface CartRepository extends JpaRepository<Cart, Long> {

        @Query("SELECT new com.synergy.backend.domain.orders.model.response.CartDTO(" +
                "    c.idx, " +
                "    o.idx, " +
                "    o.majorOption.idx, " +
                "    o.majorOption.name, " +
                "    o.subOption.idx, " +
                "    o.subOption.name, " +
                "    c.count, " +
                "    c.price, " +
                "    p.name, " +
                "    p.idx, " +
                "    a.name, " +
                "    a.idx )" +
                "FROM OptionInCart o " +
                "JOIN o.cart c " +
                "JOIN c.product p " +
                "JOIN p.atelier a " +
                "WHERE c.idx IN (" +
                "    SELECT c2.idx " +
                "    FROM Cart c2 " +
                "    WHERE c2.member.idx = :userIdx" +
                ")")
        List<CartDTO> findByUserIdx(Long userIdx);
    }
