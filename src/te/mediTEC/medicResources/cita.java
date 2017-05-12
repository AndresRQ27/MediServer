package te.mediTEC.medicResources;

import java.util.ArrayList;
import java.util.List;

public class cita {
	private static List<String> sintomas;
	private static List<casoClinico> casosClinicos;
	private static List<examen> examenes;
	private static List<medic> medicamentos;
	private String paciente;
	private String doctor;
	private int cosTotal = 0;
	private int codigo;
	private boolean finalizado = false;
	
	public cita(){
	}

	public cita(String paciente,String doctor, ArrayList<String> sintomas) {
		paciente = paciente;
		sintomas = sintomas;
		doctor = doctor;
		codigo  = 222;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public  List<String> getSintomas() {
		return sintomas;
	}

	public  void setSintomas(List<String> sintomas) {
		cita.sintomas = sintomas;
	}

	public  List<casoClinico> getCasosClinicos() {
		return casosClinicos;
	}

	public  void setCasosClinicos(List<casoClinico> casosClinicos) {
		cita.casosClinicos = casosClinicos;
	}

	public  List<examen> getExamenes() {
		return examenes;
	}

	public  void setExamenes(List<examen> examenes) {
		cita.examenes = examenes;
	}

	public  List<medic> getMedicamentos() {
		return medicamentos;
	}

	public  void setMedicamentos(List<medic> medicamentos) {
		cita.medicamentos = medicamentos;
	}

	public int getCosTotal() {
		return cosTotal;
	}

	public void setCosTotal(int cosTotal) {
		this.cosTotal = cosTotal;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	
	

}
