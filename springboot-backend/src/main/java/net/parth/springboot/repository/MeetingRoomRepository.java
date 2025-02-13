package net.parth.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import net.parth.springboot.model.MeetingRoom;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {

}
