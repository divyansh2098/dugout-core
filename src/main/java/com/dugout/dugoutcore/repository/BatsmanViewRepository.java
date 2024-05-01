package com.dugout.dugoutcore.repository;

import com.dugout.dugoutcore.models.BatsmanView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BatsmanViewRepository extends JpaRepository<BatsmanView, Long> {
    @Query(nativeQuery = true, value = "SELECT bv.* FROM batsman_view bv WHERE bv.inning_id = :inningId AND bv.player_id = :playerId")
    public BatsmanView findBatsmanViewByInningIdAndPlayerId(Long inningId, Long playerId);
}
