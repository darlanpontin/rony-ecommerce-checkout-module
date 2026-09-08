package br.com.rony.ecommerce.domain.exceptions;

import br.com.rony.ecommerce.domain.services.fraud.FraudDetectionService;

/**
 * Exceção para bloqueios por fraude.
 */
public class FraudDetectedException extends RuntimeException {
    private FraudDetectionService.FraudAnalysisResult fraudAnalysis;
    
    public FraudDetectedException(String message, FraudDetectionService.FraudAnalysisResult fraudAnalysis) {
        super(message);
        this.fraudAnalysis = fraudAnalysis;
    }
    
    public FraudDetectionService.FraudAnalysisResult getFraudAnalysis() {
        return fraudAnalysis;
    }
}
