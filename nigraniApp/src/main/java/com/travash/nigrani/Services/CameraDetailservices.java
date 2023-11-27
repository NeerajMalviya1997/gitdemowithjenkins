package com.travash.nigrani.Services;

import java.util.List;

import com.travash.nigrani.Model.CameraDetails;

public interface CameraDetailservices {

	public CameraDetails addCamera(CameraDetails cameraDetails);
	public CameraDetails deleteCamera(Integer cameraID);
	public CameraDetails updateCamera(Integer cameraId, CameraDetails cameraDetails);
	public CameraDetails getCameraByCameraId(Integer cameraId);
	public List<CameraDetails> getAllCamera();
	
}
