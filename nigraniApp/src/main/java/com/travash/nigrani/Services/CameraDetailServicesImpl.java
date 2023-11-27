package com.travash.nigrani.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travash.nigrani.ExceptionHandler.CameraNotFoundException;
import com.travash.nigrani.Model.CameraDetails;
import com.travash.nigrani.Repositories.CameraDetailRepo;

@Service
public class CameraDetailServicesImpl implements CameraDetailservices {
	
	
	
	@Autowired
	private CameraDetailRepo cameraDetailRepo;

	@Override
	public CameraDetails addCamera(CameraDetails cameraDetails) {
		return cameraDetailRepo.save(cameraDetails);
	}

	@Override
	public CameraDetails deleteCamera(Integer cameraID) {
		Optional<CameraDetails> cameraDetails =cameraDetailRepo.findById(cameraID);
		if(!cameraDetails.isPresent()) {
			new CameraNotFoundException("need to pass");
		}
		
		cameraDetailRepo.deleteById(cameraID);
		return cameraDetails.get();
	}

	@Override
	public CameraDetails updateCamera(Integer cameraId, CameraDetails cameraDetails) {
		Optional<CameraDetails> updatecameraDetails =cameraDetailRepo.findById(cameraId);
		if(!updatecameraDetails.isPresent()) {
			new CameraNotFoundException("need to pass");
		}
		
		updatecameraDetails.get().setCameraCompany(cameraDetails.getCameraCompany());
		updatecameraDetails.get().setCameraUrl(cameraDetails.getCameraUrl());
		cameraDetailRepo.save(updatecameraDetails.get());
		
		return updatecameraDetails.get();
	}

	@Override
	public CameraDetails getCameraByCameraId(Integer cameraId) {
		Optional<CameraDetails> cameraDetails =cameraDetailRepo.findById(cameraId);
		if(!cameraDetails.isPresent()) {
			new CameraNotFoundException("need to pass");
		}
		
		return cameraDetails.get();
	}

	@Override
	public List<CameraDetails> getAllCamera() {
		 List<CameraDetails> cameraDetails =cameraDetailRepo.findAll();
	
		
		return cameraDetails;
	}

}
