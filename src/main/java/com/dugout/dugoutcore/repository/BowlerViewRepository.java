package com.dugout.dugoutcore.repository;

import com.dugout.dugoutcore.models.BowlerView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BowlerViewRepository extends JpaRepository<BowlerView, Long> {

    @Query(nativeQuery = true, value = "SELECT bv.* FROM bowler_view WHERE bv,inning_id = :inningId AND bv.player_id = :player_id")
    public BowlerView findBowlerViewByInningIdAndPlayerId(Long inningId, Long playerId);
}
