package com.example.Citas.Medicas.Interfaces;

public interface IMedicoPaciente {
    public String savePacienteMedico(Long idM, Long idP);
    public String deleteMedicoDePaciente(Long idM, Long idP);

}
