package gr.codehub.guide.filmrepository.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.codehub.guide.filmrepository.model.Actor;
import gr.codehub.guide.filmrepository.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {
	@Autowired
	ActorRepository actorRepository;

	@Override
	public void create(final Actor actor) {
		actorRepository.save(actor);
	}

	@Override
	public void update(final Actor actor) {
		actorRepository.save(actor);
	}

	@Override
	public void delete(final Long id) {
		actorRepository.deleteById(id);
	}

	@Override
	public void delete(final Actor actor) {
		actorRepository.delete(actor);
	}

	@Override
	public boolean exists(final Actor actor) {
		return locate(actor.getId()) != null;
	}

	@Override
	public Actor get(final Long id) {
		return locate(id);
	}

	@Override
	public List<Actor> findAll() {
		return actorRepository.findAll();
	}

	private Actor locate(final Long id) {
		final Optional<Actor> actorOptional = actorRepository.findById(id);

		if (!actorOptional.isPresent()) {
			actorOptional
				.orElseThrow(() -> new NullPointerException(String.format("Actor with id %d was not found.", id)));
		}
		return actorOptional.get();
	}
}