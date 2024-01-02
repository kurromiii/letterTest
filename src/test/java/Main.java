
import com.mftplus.lettertest.model.entity.Letter;

import com.mftplus.lettertest.model.service.LetterService;

public class Main {
    public static void main(String[] args) throws Exception {
//        ULocale locale = new ULocale("fa_IR@calendar=persian");
//        Calendar calendar = Calendar.getInstance(locale.toLocale());
//        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale.toLocale());
//        System.out.println(df.format(calendar));
//        System.out.println("Current Calendar's Year: " + calendar.get(Calendar.YEAR));
//        System.out.println("Current Calendar's Year: " + calendar.get(Calendar.MONTH));
//        System.out.println("Current Calendar's Year: " + calendar.get(Calendar.DATE));

        Letter letter =
                Letter.builder()
                        .context("mhhaij akdoihsdf jhdsfhdf hfdhsdfhsd hi this is me kjsdfugds")
                                .build();
        LetterService.getUserService().save(letter);
        LetterService.getUserService().findByPartOfText("hi this is me");

//            try {
//                EntityTransaction entityTransaction = JpaProvider.getJpa().getEntityManager().getTransaction();
//                entityTransaction.begin();
//            GeneratedSequence generatedSequence
//                    = GeneratedSequence.builder().build();
//            generatedSequence = GeneratedSequenceService.generatedSequenceService().save(generatedSequence);
//
//            Letter letter =
//                    Letter.builder().myVal(generatedSequence).build();
//            letter.letterNumberGenerator(String.valueOf(generatedSequence.getId()));
//            LetterService.getUserService().save(letter);
//            entityTransaction.commit();
//            }catch (Exception e){
//                EntityTransaction entityTransaction = JpaProvider.getJpa().getEntityManager().getTransaction();
//                entityTransaction.rollback();
//            }









    }
}
