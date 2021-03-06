/*
 * Copyright 2021 Delft University of Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package server;

import commons.Question;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import server.api.ActivityController;
import server.database.ActivityRepository;

import java.util.HashMap;

@SpringBootApplication
@EntityScan(basePackages = {"commons", "server"})
public class Main {

    public static HashMap<Integer, Question[]> map = new HashMap<Integer, Question[]>();

    public static ActivityRepository repository;

    /**
     * Constructor.
     * @param repository repository of activities
     */
    public Main(ActivityRepository repository) {
        Main.repository = repository;
    }

    /**
     * Runs the application.
     * Initializes the database.
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        ActivityController controller = new ActivityController(repository);
        controller.initializeDataBase();
    }
}