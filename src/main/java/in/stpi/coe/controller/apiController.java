package in.stpi.coe.controller;

import in.stpi.coe.entity.coe;
import in.stpi.coe.entity.timeline;
import in.stpi.coe.repository.chartsDataRepository;
import in.stpi.coe.entity.chartsData;
import in.stpi.coe.repository.coeRepository;
import in.stpi.coe.repository.timelineRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

@RestController("/api")
public class apiController {
    @Autowired
    private chartsDataRepository chartsDataRepository;
    @Autowired
    private coeRepository coeRepository;
    @Autowired
    private timelineRepository timelineRepository;
    @GetMapping("/transform_old_excel_data_to_new_excel_format")
    private void updateData(){
        try {
            FileInputStream file_to_read = new FileInputStream("/home/stpi/Downloads/export_data.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file_to_read);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Double[][] data = new Double[781][27];
            int k = 0;
            int l = -1;
            int oldItr = 0;
            int i=0;
            while (i < 433) {
                Row row = sheet.getRow(i+1);
                if (row != null) {
                    if (i % 27 != 0) {
                        k = oldItr;
                        l += 1;
                    } else {
                        k = ((i + 1) / 27) * 30;
                        oldItr = k;
                        l = 0;
                    }
                    int j = 7;
                    while (j < 37) {
                        data[k][l] = row.getCell(j).getNumericCellValue();
                        k += 1;
                        j += 1;
                    }
                }
                i+=1;

            }
            file_to_read.close();
            XSSFWorkbook workbook_to_write = new XSSFWorkbook();
            sheet = workbook_to_write.createSheet();
            for (i=1;i<data.length;i++){
                Row row = sheet.createRow(i);
                for (int j=0;j<data[i].length;j++){
                    Cell cell = row.createCell(j);
                    if (data[i-1][j] != null) {
                        cell.setCellValue(data[i-1][j]);
                    }
                }
            }
            FileOutputStream file_to_write = new FileOutputStream("/home/stpi/Downloads/import_data_all_info.xlsx");
            workbook_to_write.write(file_to_write);
            file_to_write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/create_chart_data_objects_from_transformed_excel_sheet")
    private void createData(){
        try {
            FileInputStream file_to_read = new FileInputStream("/home/stpi/Downloads/import_data_all_info.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file_to_read);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int i = 0;
            while (i < 481) {
                Row row = sheet.getRow(i+1);
                if (row != null) {
                    chartsData chartsData = new chartsData();
                    int j = 0;
                    while (j <= row.getLastCellNum()) {
                        switch (j) {
                            case 0 -> chartsData.setAcademicPartners((int) row.getCell(j).getNumericCellValue());
                            case 1 -> chartsData.setAllPartners((int) row.getCell(j).getNumericCellValue());
                            case 2 -> chartsData.setContestsConducted((int) row.getCell(j).getNumericCellValue());
                            case 3 -> chartsData.setEmploymentGeneration((int) row.getCell(j).getNumericCellValue());
                            case 4 -> chartsData.setFiveLakhsToFifteenLakhs((int) row.getCell(j).getNumericCellValue());
                            case 5 -> chartsData.setFundRaised(row.getCell(j).getNumericCellValue());
                            case 6 ->
                                    chartsData.setFundingInvestmentAgencies((int) row.getCell(j).getNumericCellValue());
                            case 7 ->
                                    chartsData.setIndustryAssociationsPartners((int) row.getCell(j).getNumericCellValue());
                            case 8 -> chartsData.setIpr((int) row.getCell(j).getNumericCellValue());
                            case 9 -> chartsData.setKnowledgePartners((int) row.getCell(j).getNumericCellValue());
                            case 10 -> chartsData.setLessThanFiveLakhs((int) row.getCell(j).getNumericCellValue());
                            case 11 -> chartsData.setMentorsEnrolled((int) row.getCell(j).getNumericCellValue());
                            case 12 -> chartsData.setMoreThenFifteenLakhs((int) row.getCell(j).getNumericCellValue());
                            case 13 ->
                                    chartsData.setOutreachProgramsConducted((int) row.getCell(j).getNumericCellValue());
                            case 14 -> chartsData.setProduct((int) row.getCell(j).getNumericCellValue());
                            case 15 -> chartsData.setPrototype((int) row.getCell(j).getNumericCellValue());
                            case 16 -> chartsData.setResearchOrganizations((int) row.getCell(j).getNumericCellValue());
                            case 17 -> chartsData.setRevenueGenerated(row.getCell(j).getNumericCellValue());
                            case 18 -> chartsData.setStartupValuation(row.getCell(j).getNumericCellValue());
                            case 19 -> chartsData.setStartupsOnboarded((int) row.getCell(j).getNumericCellValue());
                            case 20 ->
                                    chartsData.setStartupsParticipatedInCoEActivities((int) row.getCell(j).getNumericCellValue());
                            case 21 -> chartsData.setStartupsSelected((int) row.getCell(j).getNumericCellValue());
                            case 22 -> chartsData.setStartupsTargeted((int) row.getCell(j).getNumericCellValue());
                            case 23 ->
                                    chartsData.setStateCentralGovernmentAgenciesOnboarded((int) row.getCell(j).getNumericCellValue());
                            case 24 ->
                                    chartsData.setTrainingMentoringProgramsConducted((int) row.getCell(j).getNumericCellValue());
                            case 25 -> {
                                int timeline_id = (int) row.getCell(j).getNumericCellValue();
                                if (timelineRepository.findById(timeline_id).isPresent()) {
                                    timeline timeline = timelineRepository.findById(timeline_id).get();
                                    chartsData.setTimeline(timeline);
                                }
                            }
                            case 26 -> {
                                int coe_id = (int) row.getCell(j).getNumericCellValue();
                                Optional<coe> tempCoe = coeRepository.findByCoeId(coe_id);
                                if (tempCoe.isPresent()) {
                                    coe coe = tempCoe.get();
                                    chartsData.setCoe(coe);
                                }
                            }
                        }
                        j += 1;
                    }
                    chartsDataRepository.save(chartsData);
                }
                i+=1;

            }
            file_to_read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
