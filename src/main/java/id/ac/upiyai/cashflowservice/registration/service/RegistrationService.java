package id.ac.upiyai.cashflowservice.registration.service;

import id.ac.upiyai.cashflowservice.registration.model.PersonalInformation;
import id.ac.upiyai.cashflowservice.registration.model.Registration;
import id.ac.upiyai.cashflowservice.registration.model.RegistrationStep;
import id.ac.upiyai.cashflowservice.registration.model.SpouseInformation;
import id.ac.upiyai.cashflowservice.registration.model.request.RegistrationRequest;
import id.ac.upiyai.cashflowservice.registration.model.response.RegistrationResponse;
import id.ac.upiyai.cashflowservice.registration.repository.PersonalInformationRepository;
import id.ac.upiyai.cashflowservice.registration.repository.RegistrationRepository;
import id.ac.upiyai.cashflowservice.registration.repository.RegistrationStepRepository;
import id.ac.upiyai.cashflowservice.registration.repository.SpouseInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationRepository repository;
    private final PersonalInformationRepository personalRepository;
    private final SpouseInformationRepository spouseRepository;
    private final RegistrationStepRepository stepRepository;

    public RegistrationResponse registerBasicInfo(RegistrationRequest request){
        RegistrationResponse data = new RegistrationResponse();

        PersonalInformation personal = new PersonalInformation();
        personal.setSurname(request.getFullName());
        personal.setGender(request.getGender());
        personal.setIdentityType(request.getIdentityType());
        personal.setIdentityNumber(request.getIdentityNumber());
        personal.setAddress(request.getAddress());
        personal.setPhoneNumber(request.getPhoneNumber());
        personal.setResidential(request.getResidential());
        personal.setBirthPlace(request.getBirthPlace());
        personal.setDateOfBirth(request.getDateOfBirth());
        personalRepository.save(personal);

        SpouseInformation spouse = new SpouseInformation();
        spouse.setSurname(request.getSpouseName());
        spouse.setOccupation(request.getSpouseOccupation());
        spouseRepository.save(spouse);

        RegistrationStep step = stepRepository.findById(2L).orElseThrow(() -> new NotFoundException("Not Found"));

        Registration registration = new Registration();
        registration.setStep(step);
        repository.save(registration);
        return data;
    }
}
