package com.github.etinaa.assignment.players.service;

import com.github.etinaa.assignment.players.data.Player;
import com.github.etinaa.assignment.players.data.PlayerDto;
import com.github.etinaa.assignment.players.data.PlayerRepository;
import com.github.etinaa.assignment.players.data.SortField;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository repository;
    private final PlayerMapper mapper;

    public Page<PlayerDto> getAllByPage(final int pageNumber, final int pageSize, final SortField sortField,
                                        final Sort.Direction sortDirection) {
        final Pageable pageable = PageRequest.of(pageNumber, pageSize, sortDirection, sortField.getDbFieldName());
        return repository.findAll(pageable).map(mapper::toDto);
    }

    public PlayerDto getByPlayerId(final String playerId) {
        final Player player = repository.getReferenceById(playerId);
        return mapper.toDto(player);
    }
}
