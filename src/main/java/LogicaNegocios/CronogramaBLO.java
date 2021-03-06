package LogicaNegocios;

import AccesoDatos.CronogramasDAO;
import Entidades.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Progra
 */
public class CronogramaBLO {

    private String msg;

    CronogramasDAO cronogramaDAO;
    List<EDiaFeriado> listaDiasFeriados;
    List<EDiaAusente> listaDiasAusentes;
    List<EDia> listaDias;
    String fechaInicioNueva;
    boolean simultaneo = false;

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con los
     * cronogramas que se han registrado
     *
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos
     * @return Un List con los datos de los cronogramas que coincidieron con la
     * condición
     * @throws Exception Arroja una excepción genérica
     */
    public List<EModuloCronograma> listar(String condicion) throws Exception {
        List<EModuloCronograma> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listar(condicion);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con todos los
     * días feriados de un año.
     *
     * @param anio recibe por parámetro un año.
     * @return Retorna la lista de feriados de un año-
     * @throws SQLException Arroja un excepción de SQL en caso de que la base de
     * datos tenga un fallo
     * @throws Exception Arroja una excepción genérica
     */
    public List<EDiaFeriado> listarDias(int anio) throws Exception {
        List<EDiaFeriado> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listarDias(anio);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con todos los que
     * se ausentó un profesor.
     *
     * @param profesor Recibe el profesor el cuál quiere revisar cuales días
     * falto.
     * @param fechaInicio Recibe la fecha de inicio de la cual se quiere empezar
     * a revisar.
     * @return Retorna una lista de días ausentes.
     * @throws Exception Arroja una excepción genérica
     */
    public List<EDiaAusente> listarDias(EProfesor profesor, String fechaInicio) throws Exception {
        List<EDiaAusente> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listarDias(profesor, fechaInicio);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con todos los
     * profesores de un módulo de un programa.
     *
     * @param cronograma Recibe un objeto un cronograma.
     * @return Retorna una lista de profesores.
     * @throws Exception Arroja una excepción genérica
     */
    public List<EProfesor> listar(EModuloCronograma cronograma, String condicion) throws Exception {
        List<EProfesor> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listar(cronograma, condicion);
        } catch (Exception e) {
            throw e;
        }
        return lista;

    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con todos los
     * módulos registrados.
     *
     * @param condicion Condicion por la que se quiere filtrar en base de datos
     * @return Objeto List con los módulos encontrados en la base de datos
     * @throws Exception Arroja una excepción genérica
     */
    public List<EModulo> listarModulos(String condicion) throws Exception {
        List<EModulo> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listarModulos(condicion);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con todos los
     * programas registrados.
     *
     * @param condicion Condicion por la que se quiere filtrar en base de datos
     * @return Objeto List con los programas encontrados en la base de datos
     * @throws Exception Arroja una excepción genérica
     */
    public List<EPrograma> listarProgramas(String condicion) throws Exception {
        List<EPrograma> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listarProgramas(condicion);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos una lista con todos los
     * profesores registrados.
     *
     * @param condicion Condicion por la que se quiere filtrar en base de datos
     * @return Objeto List con los profesores encontrados en la base de datos
     * @throws Exception Exception Arroja una excepción genérica
     */
    public List<EProfesor> listarProfesores(String condicion) throws Exception {
        List<EProfesor> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listarProfesores(condicion);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que trae de la base de datos un cronograma según la
     * condición que se quiera filtrar.
     *
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos.
     * @return Retorna un cronograma
     * @throws Exception Arroja una excepción genérica
     */
    public EModuloCronograma obtener(String condicion) throws Exception {
        EModuloCronograma cronograma;
        try {
            cronogramaDAO = new CronogramasDAO();
            cronograma = cronogramaDAO.obtener(condicion);
        } catch (Exception e) {
            throw e;
        }
        return cronograma;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que inserta en la base de datos un cronograma.
     *
     * @param cronograma Recibe objeto cronograma
     * @param idAsigPr Recibe una asiganación de profesor, extraer id desde la
     * base de datos.
     * @return Retorna -1 si no se pudo insertar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws Exception Arroja una excepción genérica
     */
    public int insertar(EModuloCronograma cronograma, int idAsigPr) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.insertar(cronograma, idAsigPr);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que asigna un profesor a un modulo de un programa.
     *
     * @param cronograma Recibe un objeto cronógrama.
     * @return Retorna -1 si no se inserto nada, de lo contrario retorna 1.
     * @throws Exception Arroja una excepción genérica
     */
    public int insertar(EModuloCronograma cronograma) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.insertar(cronograma);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que actualiza en la base de datos un cronograma.
     *
     * @param cronograma Recibe objeto cronograma
     * @param idAsigPr Recibe una asiganación de profesor, extraer id desde la
     * base de datos.
     * @return Retorna -1 si no se pudo actualizar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws Exception Arroja una excepción genérica
     */
    public int actualizar(EModuloCronograma cronograma, int idAsigPr) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.actualizar(cronograma, idAsigPr);
        } catch (Exception e) {
            throw e;
        }
        return resultado;

    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que actualiza en la base de datos una asignación de un
     * profesor a un módulo de un programa.
     *
     * @param cronograma Recibe objeto cronograma
     * @return Retorna -1 si no se pudo actualizar, en caso contrario retorna el
     * numero de filas afectadas.
     * @throws Exception Arroja una excepción genérica
     */
    public int actualizar(EModuloCronograma cronograma) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.actualizar(cronograma);
        } catch (Exception e) {
            throw e;
        }
        return resultado;

    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que elimina en la base de datos un módulo de un
     * cronograma.
     *
     * @param cronograma Recibe objeto cronograma
     * @return Retorna -1 si no se pudo eliminar, en caso contrario retorna el
     * numero de filas afectadas.
     * @throws Exception Arroja una excepción genérica
     */
    public int eliminar(EModuloCronograma cronograma) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.eliminar(cronograma);
        } catch (Exception e) {
            throw e;
        }
        return resultado;

    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que inserta el día de ausencia.
     *
     * @param diaA Recibe un EDiaAusente con la informacíon que se quiere
     * insertar.
     * @return Retorna -1 si no se inserto nada, de lo contrario retorna 1.
     * @throws Exception Arroja una excepción genérica
     */
    public int insertarDiaA(EDiaAusente diaA) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.insertarDiaA(diaA);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que modifica el día de ausencia.
     *
     * @param diaA Es el objeto EDiaAusente nuevo que tiene la información nueva
     * que sustituir
     * @param diaAAnterior Es el objeto EDiaAusente anterior para identificar
     * donde sustituir
     * @return Retorna -1 si no se pudo modificar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws Exception Arroja una excepción génerica
     */
    public int actualizarDiaA(EDiaAusente diaA, EDiaAusente diaAAnterior) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.actualizarDiaA(diaA, diaAAnterior);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que elimina el día de ausencia.
     *
     * @param diaA Es el objeto EDiaAusente que tiene la información para saber
     * donde eliminar
     * @return Retorna -1 si no se pudo eliminar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws Exception Arroja una excepción génerica
     */
    public int eliminarDiaA(EDiaAusente diaA) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.eliminarDiaA(diaA);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que retorna una lista de las ausencias en la base de
     * datos.
     *
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos
     * @return Objeto List con la información de los dias ausentes requeridos
     * @throws Exception Retorna excepción genérica.
     */
    public List<EDiaAusente> listarDiasA(String condicion) throws Exception {
        List<EDiaAusente> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listarDiasA(condicion);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que retorna un EDiaAusente de la base de datos.
     *
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos
     * @return Objeto EDiaAusente con la información de el dia ausente obtenido
     * @throws Exception Retorna excepción genérica.
     */
    public EDiaAusente obtenerDiaA(String condicion) throws Exception {
        EDiaAusente dia;
        try {
            cronogramaDAO = new CronogramasDAO();
            dia = cronogramaDAO.obtenerDiaA(condicion);
        } catch (Exception e) {
            throw e;
        }
        return dia;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que retorna una lista de los motivos de ausencias en la
     * base de datos.
     *
     * @param condicion Condicion por la que se quiere filtrar en la base de
     * datos
     * @return Objeto List con la información de los motivos de ausentes
     * requeridos
     * @throws Exception Retorna excepción genérica.
     */
    public List<EMotivoAusencia> listarMotivos(String condicion) throws Exception {
        List<EMotivoAusencia> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listarMotivos(condicion);
        } catch (Exception e) {
            throw e;
        }
        return lista;

    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que inserta un motivo de ausencia.
     *
     * @param motivo Recibe un EMotivoAusencia con la informacíon que se quiere
     * insertar.
     * @return Retorna -1 si no se inserto nada, de lo contrario retorna 1.
     * @throws Exception Arroja una excepción genérica
     */
    public int insertarMotivo(EMotivoAusencia motivo) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.insertarMotivo(motivo);
        } catch (Exception e) {
            throw e;
        }
        return resultado;

    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que modifica un motivo de ausencia.
     *
     * @param motivo Es el objeto EMotivoAusencia nuevo que tiene la información
     * nueva que sustituir
     * @return Retorna -1 si no se pudo modificar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws Exception Arroja una excepción génerica
     */
    public int actualizarMotivo(EMotivoAusencia motivo) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.actualizarMotivo(motivo);
        } catch (Exception e) {
            throw e;
        }
        return resultado;

    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que elimina un motivo de ausencia.
     *
     * @param motivo Es el objeto EMotivoAusencia que tiene la información para
     * saber donde eliminar
     * @return Retorna -1 si no se pudo eliminar, en caso contrario retorna el
     * numero de filas afectadas
     * @throws Exception Arroja una excepción génerica
     */
    public int eliminarMotivo(EMotivoAusencia motivo) throws SQLException, Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.eliminarMotivo(motivo);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    /**
     * Este método se encarga redireccionar a la capa de acceso a datos para
     * usar otro método que elimina en la base de datos un cronograma
     *
     * @param idPrograma Valor en entero que recibe un id de un cronograma
     * @return Retorna -1 si no se pudo eliminar, en caso contrario retorna el
     * numero de filas afectadas.
     * @throws Exception Arroja una excepción genérica
     */
    public int eliminar(int idPrograma) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.eliminar(idPrograma);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    /**
     * Este módulo se encarga de calcular el cronograma de un módulo.
     *
     * @param cronograma Es el objeto EMóduloCronograma al que se le calculará
     * su fecha fin.
     * @param fechaInicio
     * @return Una cadena diciendo si el proceso se realizó correctamente.
     * @throws Exception Arroja una excepción genérica
     */
    public String calcularCronograma(EModuloCronograma cronograma, String fechaInicio) throws Exception {
        Calendar calendario = Calendar.getInstance(); //Calendario que se va a rrecorrer
        EProfesor profe = new EProfesor(); //Objeto profesor que se usa en la evaluación 
        boolean existe = false;
        boolean variosProfes = false;
        try {
            cronogramaDAO = new CronogramasDAO(); //Instancia de CronogramasDAO para acceder a la capa de datos.
            String[] arreglosFecha = fechaInicio.split("-");
            int mesInicio = Integer.parseInt(arreglosFecha[1]);//Se va a descomponer la cadena de la fecha inicial del modulo para extraer su mes de inicio.
            int dia = Integer.parseInt(arreglosFecha[2]);//Se va a descomponer la cadena de la fecha inicial del modulo para extraer su día de inicio.
            int anio = Integer.parseInt(arreglosFecha[0]);//Se va a descomponer la cadena de la fecha inicial del modulo para extraer su año de inicio.
            cronogramaDAO = new CronogramasDAO();
            listaDiasFeriados = cronogramaDAO.listarDias(anio);//Se listan los días feriados del año.
            profe = cronograma.getProfesor().get(0);//El objeto profesor se le asigna el primer profesor del ArrayList profesores del cronograma.
            cronogramaDAO = new CronogramasDAO();
            if (cronogramaDAO.listar(cronograma, "").size() <= 1) {

                cronogramaDAO = new CronogramasDAO();
                listaDiasAusentes = cronogramaDAO.listarDiasA(" idProfesor = " + cronograma.getProfesor().get(0).getIdPersona());//Se listan los dias que está ausente el profeosr
            } else {
                variosProfes = true;
            }
            cronogramaDAO = new CronogramasDAO();
            listaDias = cronogramaDAO.listarDiasPrograma(" p.idPrograma = " + cronograma.getPrograma().getIdPrograma());
            cronograma.setFechaInicio(fechaInicio);
            double horasPorDia = obtenerHorasDia(cronograma.getHoraInicio(), cronograma.getHoraFin());//Este método obtiene la cantodad de horas por día de un módulo
            cronograma.setHorasDia(String.valueOf(horasPorDia));
            cronogramaDAO = new CronogramasDAO();
            double horasTotalesModulo = (cronograma.getModulo().getHorasTotales() + Math.round(horasPorDia));
            boolean bandera = false;
            boolean bandera2 = false;
            double contadorHoras = 0;//Contador de las horas dadas que por día, se va a comparar con las horas totales del módulo
            int i = mesInicio;
            while (!bandera) {
                int x = 0;
                if ((mesInicio) == i) {//Si el mes de inicio es igual al mes iterado
                    x = dia;//La variable x se le asigna el día extraído de la fecha inicial
                } else {
                    x = 1;//Si no se le asigna 1
                }

                calendario.set(anio, --i, 1);
                i++;
                int lastDay = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
                for (; x <= lastDay; x++) { //Aqui se rrecorren los días del mes, desde el día que se asignó anteriormente hasta el último día del mes
                    if (i == 12 && x == 31) {//Si el mes llega a ser el último del año y se llega a su último día 
                        anio++;//Se cambia de año para iterrar
                        i = 1;
                        cronogramaDAO = new CronogramasDAO();
                        listaDiasFeriados = cronogramaDAO.listarDias(anio);//Se vuelven a listar los días feriado pero del nuevo año
                    }
                    if (bandera2) {
                        fechaInicioNueva = String.valueOf(anio + "-" + i + "-" + x);
                        bandera = true;
                        break;
                    }
                    if (verificarDiasPrograma(anio, i, x)) {
                        if (variosProfes) {
                            cronogramaDAO = new CronogramasDAO();
                            EProfesor profesor = cronogramaDAO.listar(cronograma, "a.fechaFin >= '" + String.valueOf(anio + "-" + i + "-" + x) + "' and a.fechaInicio <= '" + String.valueOf(anio + "-" + i + "-" + x) + "'").get(0);
                            cronogramaDAO = new CronogramasDAO();
                            listaDiasAusentes = cronogramaDAO.listarDiasA(" idProfesor = " + cronograma.getProfesor().get(0).getIdPersona());//Se listan los dias que está ausente el profeosr
                        }

                        if (!revisarDia((anio + "-" + i + "-" + x), anio, i, x)) {//Se revisa si la fecha iterada está en los dias de ausencia o la lista de dias feriados
                            if (contadorHoras == 0) {
                                fechaInicio = String.valueOf(anio + "-" + i + "-" + x);
                                cronograma.setFechaInicio(fechaInicio);
                            }
                            contadorHoras += horasPorDia;//Si el resultado es negativo se le suman las horas por día
                            if (contadorHoras >= horasTotalesModulo) {//Cuando el contador de horas es el mismo que las horas totales del módulo 
                                cronograma.setFechaFin(anio + "-" + i + "-" + x);//A la fecha fin del cronograma se le asignará la fecha que se lleva iterada
                                bandera2 = true;
                            }
                        }
                    }

                }
                if (bandera2 == false) {
                    i++;
                }

            } /// FIN WHILE

            cronogramaDAO = new CronogramasDAO();
            if (cronogramaDAO.obtener("m.idModulo = " + cronograma.getModulo().getIdModulo() + " and p.idPrograma = " + cronograma.getPrograma().getIdPrograma()).getModulo() != null) {//Si se obtiene un cronograma de módulo que tenga el mismo ID de módulo y el mismo ID de programa
                cronogramaDAO = new CronogramasDAO();
                int ac1 = actualizar(cronograma,cronogramaDAO.obtenerIdAsignacion(cronograma, profe));//Se actualiza la asignación cronograma
                if (ac1 > -1) {
                    int actCro = actualizar(cronograma, ac1);//Se actualiza el cronograma del módulo
                    msg = "Cronograma calculado y actualizado";
                }
            } else {
                int insAsig = insertar(cronograma);//Se inserta la asignación cronograma
                if (insAsig > -1) {
                    int insCro = insertar(cronograma, insAsig);//Se inserta el cronograma del módulo
                    msg = "Cronograma calculado y insertado";
                }

            }
        } catch (Exception e) {
            throw e;
        }
        return msg;
    }

    /**
     * Este método se encarga de calcular horas diarias
     *
     * @param inicio Recibe una cadena con la hora inicial
     * @param fin Recibe una cadena con la hora final
     * @return La diferencia entre las horas
     */
    public double obtenerHorasDia(String inicio, String fin) {
        String[] hora = inicio.split(":");
        int horaInicio = Integer.parseInt(hora[0]);
        int minutoInicio = Integer.parseInt(hora[1]);
        hora = fin.split(":");
        int horaFin = Integer.parseInt(hora[0]);
        int minutoFin = Integer.parseInt(hora[1]);
        double resultado = 0;

        while (horaInicio < horaFin) {
            resultado++;
            horaInicio++;
        }
        if (minutoInicio == 30) {
            resultado += 0.5;
        }
        if (minutoFin == 30) {
            resultado += 0.5;
        }
        return resultado;
    }

    /**
     * Este método revisa si una fecha está en la lista de días ausentes o la
     * lista de días feriados
     *
     * @param fecha Cadena con la fecha que se va a comparar en las listas
     * @return Un booleano verdadero si encontro la fecha en algunas de las
     * listas o falso si no lo encontró
     */
    private boolean revisarDia(String fecha, int anio, int mes, int dia) throws SQLException, Exception {
        boolean bandera = false;
        try {
            cronogramaDAO = new CronogramasDAO();
            LocalDate fechaFeriado;
            LocalDate fechaActual = LocalDate.of(anio, mes, dia);
            for (EDiaFeriado fechaFeriadoL : listaDiasFeriados) {
                fechaFeriado = LocalDate.parse(fechaFeriadoL.getFecha());

                if (fechaFeriado.toString().equals(fechaActual.toString())) {
                    bandera = true;
                }
            }
            if (cronogramaDAO.revisarFecha(fecha)) {
                bandera = true;
            }
        } catch (SQLException sqlE) {
            throw sqlE;
        } catch (Exception ex) {
            throw ex;
        }
        return bandera;
    }

    /**
     * Este método recibe una lista de módulos para asignarlos a un cronograma
     *
     * @param modulos recibe un objeto List con una lista de módulos
     * @param cronograma recibe un objeto cronograma para asignar
     * @return String con cadena que nos dice como salío el calculo del
     * cronogra,
     * @throws SQLException Retorna una excepción de SQL
     * @throws Exception Retorna una excepción genérica
     */
    public String recibirModulos(List<EModuloCronograma> listaModulos, List<EModuloCronograma> listaModulosParalela, String fechaInicio) throws SQLException, Exception {
        String mensaje = "";
        try {
            for (EModuloCronograma modulo : listaModulos) {
                if (!revisarSimultaneo(modulo, listaModulosParalela)) {
                    double hora1 = obtenerHorasDia(listaModulosParalela.get(listaModulos.indexOf(modulo)).getHoraInicio(), listaModulosParalela.get(listaModulos.indexOf(modulo)).getHoraFin());
                    double hora2 = obtenerHorasDia(modulo.getHoraInicio(), modulo.getHoraFin());
                    if (hora1 > hora2) {
                        calcularCronograma(listaModulosParalela.get(listaModulos.indexOf(modulo)), fechaInicio);
                        calcularCronograma(modulo, fechaInicio);
                    } else {
                        calcularCronograma(modulo, fechaInicio);
                        calcularCronograma(listaModulosParalela.get(listaModulos.indexOf(modulo)), fechaInicio);

                    }
                    fechaInicio = fechaInicioNueva;
                    continue;
                }
                if (fechaInicioNueva != null) {
                    fechaInicio = fechaInicioNueva;
                }
                calcularCronograma(modulo, fechaInicio);
            }

        } catch (Exception e) {
            throw e;
        }

        return mensaje;
    }

    /**
     *
     * @param cronograma
     * @param profe
     * @return
     * @throws Exception
     */
    public int obtenerIdAsignacion(EModuloCronograma cronograma, EProfesor profe) throws Exception {
        int resultado;

        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.obtenerIdAsignacion(cronograma, profe);
        } catch (Exception e) {
            throw e;
        }

        return resultado;
    }

    public EMotivoAusencia obtenerMotivo(String condicion) throws Exception {
        EMotivoAusencia motivo;
        try {
            cronogramaDAO = new CronogramasDAO();
            motivo = cronogramaDAO.obtenerMotivo(condicion);
        } catch (Exception e) {
            throw e;
        }
        return motivo;

    }

    /**
     * Este método redirecciona a la capa acceso a datos para usar un método que
     * obtiene un profesor
     *
     * @param condicion condición por la que se quiere buscar en la base de
     * datos
     * @return Un EProfesor con los datos encontrados
     * @throws Exception Retorna una excepción genérica
     */
    public EProfesor obtenerProfesor(String condicion) throws SQLException, Exception {
        EProfesor profesor;
        try {
            cronogramaDAO = new CronogramasDAO();
            profesor = cronogramaDAO.obtenerProfesor(condicion);
        } catch (Exception e) {
            throw e;
        }
        return profesor;
    }

    public boolean verificarDiasPrograma(int anio, int mes, int dia) {

        LocalDate date = LocalDate.of(anio, mes, dia);
        for (EDia diaLista : listaDias) {
            if (diaLista.getDia().equals(date.getDayOfWeek().toString())) {
                return true;
            }
        }
        return false;
    }

    public List<EDiaFeriado> listarDiasF(String condicion) throws Exception {
        List<EDiaFeriado> lista = null;

        try {
            cronogramaDAO = new CronogramasDAO();
            lista = cronogramaDAO.listarDiasF(condicion);
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    public EDiaFeriado obtenerFeriado(String condicion) throws Exception {
        EDiaFeriado feriado;
        try {
            cronogramaDAO = new CronogramasDAO();
            feriado = cronogramaDAO.obtenerFeriado(condicion);
        } catch (Exception e) {
            throw e;
        }
        return feriado;
    }

    public int insertarDiaF(EDiaFeriado feriado) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.insertarDiaF(feriado);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    public int actualizarDiaF(EDiaFeriado feriado) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.actualizarDiaF(feriado);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    public int eliminarDiaF(EDiaFeriado feriado) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.eliminarDiaF(feriado);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    public EModuloCronograma obtenerCronograma(String condicion) throws Exception {
        EModuloCronograma cronograma;
        try {
            cronogramaDAO = new CronogramasDAO();
            cronograma = cronogramaDAO.obtenerCronograma(condicion);
        } catch (Exception e) {
            throw e;
        }
        return cronograma;
    }

    public EPrograma obtenerPrograma(String condicion) throws Exception {
        EPrograma programa;
        try {
            cronogramaDAO = new CronogramasDAO();
            programa = cronogramaDAO.obtenerPrograma(condicion);
        } catch (Exception e) {
            throw e;
        }
        return programa;
    }

    public EModulo obtenerModulo(String condicion) throws Exception {
        EModulo modulo;
        try {
            cronogramaDAO = new CronogramasDAO();
            modulo = cronogramaDAO.obtenerModulo(condicion);
        } catch (Exception e) {
            throw e;
        }
        return modulo;
    }

    private boolean revisarSimultaneo(EModuloCronograma modulo, List<EModuloCronograma> listaModulosParalela) {

        for (EModuloCronograma eModuloCronograma : listaModulosParalela) {
            if (modulo.getModulo().getIdModulo() == eModuloCronograma.getModulo().getIdModulo()) {
                return true;
            }
        }
        return false;
    }

    public int insertarAsignacion(EModuloCronograma cronograma, EProfesor profe) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.insertarAsignacion(cronograma, profe);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    public int actualizarAsignacion(EModuloCronograma cronograma, EProfesor profe, int idAsi) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.actualizarAsignacion(cronograma, profe, idAsi);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    public int eliminarAsignacion(int idAsi) throws Exception {
        int resultado;
        try {
            cronogramaDAO = new CronogramasDAO();
            resultado = cronogramaDAO.elimnarAsignacion(idAsi);
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
}
