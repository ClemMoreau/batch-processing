package example.billingjob;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;

public class BillingJobParametersValidator implements JobParametersValidator {
    @Override
    public void validate(JobParameters parameters) throws JobParametersInvalidException {
        String inputFile = parameters.getString("input.file");

        if (inputFile == null) {
            throw new JobParametersInvalidException("input.file parameter is required");
        }
    }
}
