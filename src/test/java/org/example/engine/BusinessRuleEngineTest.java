package org.example.engine;

import org.example.domain.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

public class BusinessRuleEngineTest {

    @Test
    public void shouldAddTwoAction() {
        //final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();

        //businessRuleEngine.addAction(()->{});
        //businessRuleEngine.addAction(()->{});

        //assertEquals(2, businessRuleEngine.count());
    }
    @Test
    public void shouldExecuteOneAction() {
        //final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine();
        //final Action action = mock(Action.class);

        //businessRuleEngine.addAction(action);
        //businessRuleEngine.run();

        //verify(action).perform();
    }
    @Test
    public void 간단조건테스트() {
        Facts facts = new Facts();
        facts.addFact("name","abc");
        facts.addFact("jobTitle","CEO");

        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);

        Action action = new Action() {
            @Override
            public void perform(Facts facts) {
                final String name = facts.getFact("name");
                //Mailer.sendEmail("www@www.www")
                System.out.println("send mail"+name);
            }
        };

        Condition condition = new Condition() {
            @Override
            public boolean evaluate(Facts facts) {
                final String jobTitle = facts.getFact("jobTitle");
                if("CEO".equals(jobTitle)) return true;
                else return false;
            }
        };

        Rule rule = new DefaultRule(action,condition);


        businessRuleEngine.addRule(rule);
        businessRuleEngine.run();

        facts.addFact("age","45");

        businessRuleEngine.addRule((fact) -> {
            final String age = fact.getFact("age");
            System.out.println(age);
        }, (fact) -> {
            final String age = facts.getFact("age");
            if("45".equals(age)) return true;
            else return false;
        });
        businessRuleEngine.run();

    }

//    @Test
//    public void 조건없는액션테스트() {
//
//        Action mockAction = mock(Action.class);
//        Facts mockFact = mock(Facts.class);
//
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFact);
//        businessRuleEngine.addAction(mockAction);
//
//        businessRuleEngine.run();
//        verify(mockAction).perform(mockFact);
//    }
//
//    @Test
//    public void 직급CEO조건액션테스트() {
//        Facts facts = new Facts();
//        facts.addFact("name","abc");
//        facts.addFact("jobTitle","CEO");
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);
//
//        Action action = new Action() {
//            @Override
//            public void perform(Facts facts) {
//                final String jobTitle = facts.getFact("jobTitle");
//                if("CEO".equals(jobTitle)) {
//                    final String name = facts.getFact("name");
//                    //Mailer.sendEmail("www@www.www")
//                    System.out.println("send mail");
//                }
//            }
//        };
//        businessRuleEngine.addAction(action);//람다식은 익명객체이므로 verify 위해 변수 action에 저장
////        businessRuleEngine.addAction(fact -> {
////            final String jobTitle = fact.getFact("jobTitle");
////            if("CEO".equals(jobTitle)) {
////                final String name = fact.getFact("name");
////                //Mailer.sendEmail("www@www.www")
////                System.out.println("send mail");
////            }
////        });
//
//        businessRuleEngine.addAction(fact -> {
//            var dealStage = Stage.valueOf(facts.getFact("stage"));
//            var amount = Double.parseDouble(facts.getFact("amount"));
//            var forecastedAmount = 0.0;
//
//            switch (dealStage) {
//                case LEAD:
//                    forecastedAmount = amount * 0.2;
//                    break;
//                case EVALUATING:
//                    forecastedAmount = amount * 0.5;
//                    break;
//                case INTERESTED:
//                    forecastedAmount = amount * 0.8;
//                    break;
//                case CLOSED:
//                    forecastedAmount = amount;
//                    break;
//            }
//
//            fact.addFact("forecastedAmount", String.valueOf(forecastedAmount));
//        });
//
//
//
//
//
//        businessRuleEngine.run();
//        verify(action).perform(facts);
//    }
    @Test
    public void count() {
    }

    @Test
    public void run() {
    }
}